/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.evaluators;

import org.whole.lang.model.IEntity;
import org.whole.lang.util.BindingUtils;

/**
 * @author Riccardo Solmi
 */
public class OuterLocalVariableEvaluator extends AbstractVariableEvaluator {
	public OuterLocalVariableEvaluator(String varName) {
		super(varName);
	}

	protected boolean isSetVariable() {
		return BindingUtils.wOuterScope(getBindings(), false).wIsSet(varName);
	}

	protected IEntity getVariable() {
		return BindingUtils.wOuterScope(getBindings(), false).wGet(varName);
	}
	
	protected void setVariable(IEntity entity) {
		BindingUtils.wOuterScope(getBindings(), false).wSet(varName, entity);
	}
	
	@Override
	public void toString(StringBuilder sb) {
		sb.append("^");
		super.toString(sb);
	}
}
