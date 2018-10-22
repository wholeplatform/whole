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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.model.Fragment;
import org.whole.lang.commons.model.ICommonsEntity;
import org.whole.lang.commons.model.Resolver;
import org.whole.lang.commons.model.StageDownFragment;
import org.whole.lang.commons.model.StageUpFragment;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.iterators.ExecutableFactory;
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
		setExecutableResult(executableFactory().createTemplateInterpreter(entity).withSourceEntity(entity));
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
			BehaviorUtils.lazyEvaluateOnSelfBinding(entity.wGetRoot(), -1, getBindings());
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

		setExecutableResult(executableFactory().createTemplateInterpreter(entity).withSourceEntity(entity));
	}

	@SuppressWarnings("unchecked")
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

		Map<IEntity, IExecutable<?>> fragmentIteratorMap = new HashMap<>();
		IEntity oldSelfEntity = getBindings().wGet(IBindingManager.SELF);
		int stage = getStage();

		fragments.forEach((f) -> {
			getBindings().enforceSelfBinding(oldSelfEntity);

			setResult(null);
			IExecutable<?> fragmentIterator = null;
			if (Matcher.matchAnyImpl(f, CommonsEntityDescriptorEnum.StageDownFragment)) {
				stagedVisit(f.wGetRoot(), -stage);
				fragmentIterator = getExecutableResult();
			} else
				setExecutableResult(fragmentIterator = 
						executableFactory().createTemplateInterpreter(f).withSourceEntity(sourceEntity));

			fragmentIteratorMap.put(f, getExecutableResult());
		});

		ExecutableFactory f = executableFactory();
		IExecutable<?> compiledIterator = f.createChoose(
			f.createIf(
					f.createAtStage(0),
					f.createCompose(
							f.createChoose(
									f.createIf(
											f.createIsFragment(), f.createNestedFragment(fragmentIteratorMap)),
									f.createIf(
											f.createIsVariable(), f.createNestedVariable()),
									f.createCloneReplacing(
											f.createChoose(
													f.createIf(
															f.createIsFragment(), f.createNestedFragment(fragmentIteratorMap)),
													f.createIf(
															f.createIsVariable(), f.createNestedVariable())
											), Set.of(
											CommonsEntityDescriptorEnum.StageUpFragment.getURI(),
											CommonsEntityDescriptorEnum.StageDownFragment.getURI(),
											CommonsEntityDescriptorEnum.Variable.getURI(),
											CommonsEntityDescriptorEnum.InlineVariable.getURI()))),
							f.createConstant(rootEntity, false))),
			f.createTemplateInterpreter(fragment).withSourceEntity(sourceEntity)//TODO f.constantIterator(fragment, true)
		).withSourceEntity(sourceEntity);

		if (!nested) {
			String outerSelfName = IBindingManager.OUTER_SELF;
			compiledIterator = f.createScope(
				f.createBlock(
						f.createFilter(f.createSelf(), f.createAsVariable(outerSelfName)),
						compiledIterator
				), null, Set.of(outerSelfName), true).withSourceEntity(sourceEntity);
		}

		setExecutableResult(compiledIterator);
	}
}
