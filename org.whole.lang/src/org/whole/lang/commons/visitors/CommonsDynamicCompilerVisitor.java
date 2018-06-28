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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.whole.lang.commons.CommonsLibraryDeployer;
import org.whole.lang.commons.model.ICommonsEntity;
import org.whole.lang.commons.model.Resolver;
import org.whole.lang.commons.model.StageDownFragment;
import org.whole.lang.commons.model.StageUpFragment;
import org.whole.lang.iterators.IEntityIterator;
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
			IEntity compiled = BehaviorUtils.apply(CommonsLibraryDeployer.URI+"#constantStageUpFragmentCompiler", entity);
			IEntityIterator<?> compiledIterator = (IEntityIterator<?>) compiled.wGetValue();
			setResultIterator(compiledIterator);
			
//			setResultIterator(
//					IteratorFactory.chooseIterator(
//							IteratorFactory.ifIterator(
//									IteratorFactory.atStageIterator(0),
//									IteratorFactory.constantIterator(rootEntity, true)),
//							IteratorFactory.templateInterpreterIterator(entity)
//					).withSourceEntity(entity)
//			);
			return;
//		} else if (variables.isEmpty()) {
//			ChooseByOrderIterator<IEntity> chooseIterator = IteratorFactory.chooseIterator(
//					IteratorFactory.ifIterator(
//							IteratorFactory.constantIterator(BindingManagerFactory.instance.createValue(false), true),
//							IteratorFactory.constantIterator(rootEntity, true)),
//					IteratorFactory.emptyIterator() //placeholder for the recursive cloneIterator below
//			);
//			chooseIterator.setChildIterator(chooseIterator.childIteratorSize()-1, IteratorFactory.composeIterator(
//					IteratorFactory.cloneIterator(chooseIterator), IteratorFactory.selfIterator()));
//			chooseIterator.withSourceEntity(entity);
//
//			setResultIterator(
//					IteratorFactory.chooseIterator(
//							IteratorFactory.ifIterator(IteratorFactory.atStageIterator(0), chooseIterator),
//							IteratorFactory.templateInterpreterIterator(entity)
//					).withSourceEntity(entity)
//			);
//			return;
		} else
			fragments.isEmpty();

		super.visit(entity);
	}
}
