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
package org.whole.lang.queries.util;

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createStageUpFragment;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.StepExpression;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.iterators.AbstractPatternFilterIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.StepExpression;
import org.whole.lang.queries.model.VariableTest;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class QueriesHelpers {
	public static IEntity extractPatternDefinitions(IEntity pattern, IEntity model) {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		IEntity tuple = BindingManagerFactory.instance.createTuple();
		Matcher.match(pattern, model, bm);

		QueriesEntityFactory qef = QueriesEntityFactory.instance;
		AbstractPatternFilterIterator<IEntity> i = IteratorFactory.descendantOrSelfMatcherIterator().withPattern(CommonsEntityDescriptorEnum.VarName);
		i.reset(pattern);
		for (IEntity varName : i) {
			String name = varName.wStringValue();
			IEntity value = bm.wGet(name);
			if (EntityUtils.isVariable(value))
				continue;
			StepExpression fragment = createStageUpFragment(StepExpression, EntityUtils.cloneIfParented(value));
			VariableTest variableTest = qef.createVariableTest(name);
			tuple.wAdd(qef.createFilter(fragment, variableTest));
		}
		return tuple;
	}
}
