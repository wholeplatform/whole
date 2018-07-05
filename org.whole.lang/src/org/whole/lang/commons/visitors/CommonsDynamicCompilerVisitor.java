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
import java.util.HashSet;
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
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.GenericMatcherFactory;
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

		Set<IEntity> variables = new HashSet<>();
		List<IEntity> fragments = new ArrayList<>();
		Matcher.findAll(new AbstractVisitor() {
			public void visit(IEntity entity) {
				if (EntityUtils.isVariable(entity))
					variables.add(entity);
				if (!EntityUtils.isFragment(entity))
					throw new VisitException();
			}

			public void toString(StringBuilder sb) {
				sb.append("isFragment()");
			}
		}, rootEntity, fragments, false);
		
		if (fragments.isEmpty() && variables.isEmpty()) {
			visitFragment(entity, false);
			return;
		} else if (fragments.isEmpty()) {
			visitFragment(entity, false);
			return;
		} else
			fragments.isEmpty();

		super.visit(entity);
	}

	public void visitFragment(Fragment fragment, boolean nested) {
		IEntity sourceEntity = fragment;
		fragment = EntityUtils.clone(fragment);
		IEntity rootEntity = fragment.getRootEntity().wGetAdaptee(false);

		List<Fragment> fragments = new ArrayList<>();
		Matcher.findAll(GenericMatcherFactory.instance.isFragmentMatcher(), rootEntity, fragments, false);

		Map<IEntity, IEntityIterator<?>> fragmentIteratorMap = new HashMap<>();
//FIXME
//		fragments.forEach((e) -> {
//			setResult(null);
//			visitFragment(e, true);//FIXME
//			fragmentIteratorMap.put(e, getResultIterator());
//		});

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
											CommonsEntityDescriptorEnum.SameStageFragment.getURI(),
											CommonsEntityDescriptorEnum.Variable.getURI(),
											CommonsEntityDescriptorEnum.InlineVariable.getURI()))),
							IteratorFactory.constantIterator(rootEntity, false))),
			IteratorFactory.templateInterpreterIterator(fragment)//TODO IteratorFactory.constantIterator(fragment, true)
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
