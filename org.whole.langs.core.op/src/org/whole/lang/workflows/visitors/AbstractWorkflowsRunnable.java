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
package org.whole.lang.workflows.visitors;

import java.lang.reflect.Array;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IRunnable;
import org.whole.lang.workflows.model.Variable;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractWorkflowsRunnable implements IRunnable {
    protected static void setResult(IBindingManager bm, Variable variable, IEntity model) {
    	if (DataTypeUtils.getDataKind(variable).isString())
    		bm.wDef(variable.getValue(), model);
    	bm.setResult(model);
    }
    protected static void setResult(IBindingManager bm, Variable variable, Object resultValue, Class<?> resultType) {
		if (resultValue instanceof IEntityIterator) {
			bm.setResultIterator((IEntityIterator<?>) resultValue);
		} else if (Void.TYPE.equals(resultType)) {
			if (EntityUtils.isNotResolver(variable))
				throw new IllegalArgumentException("cannot bind a void result");
			bm.setResult(null);
		} else
			setResult(bm, variable, box(resultValue, resultType));
	}
	protected static IEntity box(Object value, Class<?> resultType) {
		if (value == null && !IEntity.class.isAssignableFrom(resultType))
			return BindingManagerFactory.instance.createSpecificValue(
					value, DataTypeUtils.toDataKind(resultType));
		else
			return DataTypeUtils.box(value, CommonsEntityDescriptorEnum.Any);
	}

	protected Object[] toArguments(Class<?>[] parameterTypes, boolean varArgs, IEntity... argsEntities) {
		int length = parameterTypes.length - (varArgs ? 1 : 0);
		int expressionsSize = argsEntities.length-2;
		if (expressionsSize < length)
			throw new IllegalArgumentException("wrong parameter number");
		
		Object[] parameters = new Object[parameterTypes.length];
		
		// map simple parameters
		for (int i = 0; i < length; i++)
			parameters[i] = DataTypeUtils.unbox(argsEntities[2+i], parameterTypes[i], true);

		// map varArgs parameters
		if (varArgs) {
			Class<?> parameterType = parameterTypes[length].getComponentType();
			Object varArgsArray = Array.newInstance(parameterType, expressionsSize - length);
			for (int j = 0, i = length; i < expressionsSize; i++, j++)
				Array.set(varArgsArray, j,  DataTypeUtils.unbox(argsEntities[2+i], parameterType, true));
			
			parameters[length] = varArgsArray;
		}
		return parameters;
	}
}
