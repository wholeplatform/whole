/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.commons.visitors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.whole.lang.commons.model.Fragment;
import org.whole.lang.commons.model.ICommonsEntity;
import org.whole.lang.commons.model.Resolver;
import org.whole.lang.commons.model.StageDownFragment;
import org.whole.lang.commons.model.StageUpFragment;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.WholeMessages;
import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public class CommonsDynamicCompilerVisitor extends CommonsIdentityDefaultVisitor {
	@Override
	public void visit(ICommonsEntity entity) {
		setResultIterator(IteratorFactory.templateInterpreterIterator(entity).withSourceEntity(entity));
	}

	@Override
	public void visit(Resolver entity) {
		IEntity parent = entity.wGetParent();
		if (!EntityUtils.isNull(parent) && !parent.wGetFeatureDescriptor(entity).isOptional())
			throw new IllegalArgumentException(WholeMessages.no_optional);
	}

	@Override
	public void visit(StageDownFragment entity) {
		if (getStage() > 0)
			super.visit(entity);
		else {
			setResult(null);
			BehaviorUtils.lazyEvaluate(entity.wGetRoot(), -1, getBindings());
		}
	}

	@Override
	public void visit(StageUpFragment entity) {
		IEntity rootEntity = entity.getRootEntity().wGetAdaptee(false);
		List<IEntity> fragments = new ArrayList<>();
		List<IEntity> stageUpFragments = new ArrayList<>();
		Matcher.findAll(new AbstractVisitor() {
			public void visit(IEntity entity) {
				if (Matcher.matchAnyImpl(entity,
						CommonsEntityDescriptorEnum.StageUpFragment))
					stageUpFragments.add(entity);

				if (!Matcher.matchAnyImpl(entity,
						CommonsEntityDescriptorEnum.StageDownFragment,
						CommonsEntityDescriptorEnum.StageUpFragment))
					throw new VisitException();
			}

			public void toString(StringBuilder sb) {
				sb.append("isStageShiftingFragment()");
			}
		}, rootEntity, fragments, false);
		
//FIXME		if (stageUpFragments.isEmpty()) {
		if (fragments.isEmpty()) {
			visitFragment(entity, false);
			return;
		}

//		setResultIterator(new InstrumentingIterator<IEntity>(IteratorFactory.templateInterpreterIterator(entity)).withSourceEntity(entity));
		setResultIterator(IteratorFactory.templateInterpreterIterator(entity).withSourceEntity(entity));
	}

	public void visitFragment(Fragment fragment, boolean nested) {
		IEntity sourceEntity = fragment;
		fragment = EntityUtils.clone(fragment);
		IEntity rootEntity = fragment.getRootEntity().wGetAdaptee(false);

		List<Fragment> fragments = new ArrayList<>();
		Matcher.findAll(new AbstractVisitor() {
			public void visit(IEntity entity) {
				if (!Matcher.matchAnyImpl(entity,
						CommonsEntityDescriptorEnum.StageDownFragment,
						CommonsEntityDescriptorEnum.StageUpFragment))
					throw new VisitException();
			}

			public void toString(StringBuilder sb) {
				sb.append("isStageShiftingFragment()");
			}
		}, rootEntity, fragments, false);

		Map<IEntity, IEntityIterator<?>> fragmentIteratorMap = new HashMap<>();
		IEntity oldSelfEntity = getBindings().wGet("self");
		int stage = getStage();

		fragments.forEach((f) -> {
        	if (getBindings().wGet("self") != oldSelfEntity)
        		getBindings().wDef("self", oldSelfEntity);

			setResult(null);
			IEntityIterator<?> fragmentIterator = null;
			if (Matcher.matchAnyImpl(f, CommonsEntityDescriptorEnum.StageDownFragment)) {
				stagedVisit(f.wGetRoot(), -stage);
				fragmentIterator = getResultIterator();
			} else
				setResultIterator(fragmentIterator = 
//						new InstrumentingIterator<IEntity>(IteratorFactory.templateInterpreterIterator(f)).withSourceEntity(sourceEntity));
						IteratorFactory.templateInterpreterIterator(f).withSourceEntity(sourceEntity));

			fragmentIteratorMap.put(f, getResultIterator());
		});

		IEntityIterator<?> compiledIterator = IteratorFactory.chooseIterator(
			IteratorFactory.ifIterator(
					IteratorFactory.atStageIterator(0),
					IteratorFactory.composeIterator(
							IteratorFactory.chooseIterator(
									IteratorFactory.ifIterator(
											IteratorFactory.isFragmentIterator(), IteratorFactory.nestedFragmentIterator(fragmentIteratorMap)),
									IteratorFactory.ifIterator(
											IteratorFactory.isVariableIterator(), IteratorFactory.nestedVariableIterator()),
									IteratorFactory.cloneReplacingIterator(
											IteratorFactory.chooseIterator(
													IteratorFactory.ifIterator(
															IteratorFactory.isFragmentIterator(), IteratorFactory.nestedFragmentIterator(fragmentIteratorMap)),
													IteratorFactory.ifIterator(
															IteratorFactory.isVariableIterator(), IteratorFactory.nestedVariableIterator())
											), Set.of(
											CommonsEntityDescriptorEnum.StageUpFragment.getURI(),
											CommonsEntityDescriptorEnum.StageDownFragment.getURI(),
											CommonsEntityDescriptorEnum.Variable.getURI(),
											CommonsEntityDescriptorEnum.InlineVariable.getURI()))),
							IteratorFactory.constantIterator(rootEntity, false))),
//			new InstrumentingIterator<IEntity>(IteratorFactory.templateInterpreterIterator(fragment)).withSourceEntity(sourceEntity)//TODO IteratorFactory.constantIterator(fragment, true)
			IteratorFactory.templateInterpreterIterator(fragment).withSourceEntity(sourceEntity)//TODO IteratorFactory.constantIterator(fragment, true)
		).withSourceEntity(sourceEntity);

		if (!nested) {
			String outerSelfName = "outerSelf";
			compiledIterator = IteratorFactory.scopeIterator(
				IteratorFactory.blockIterator(
						IteratorFactory.filterIterator(IteratorFactory.selfIterator(), IteratorFactory.asVariableIterator(outerSelfName)),
						compiledIterator
				), null, Set.of(outerSelfName), true).withSourceEntity(sourceEntity);
		}

		setResultIterator(compiledIterator);
	}
}
