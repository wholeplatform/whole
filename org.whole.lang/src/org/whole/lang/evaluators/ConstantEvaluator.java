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
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ConstantEvaluator extends AbstractPureConditionalSupplierEvaluator {
	protected IEntity constant;
    protected IEntity nextConstant;
    protected boolean useClone;

	public ConstantEvaluator(IEntity constant, boolean useClone) {
		this.useClone = useClone;
		this.constant = useClone ? EntityUtils.cloneIfParented(constant) : constant;
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		nextConstant = null;
	}

	public IEntity get() {
		if (nextConstant == null)
			nextConstant = useClone ? EntityUtils.clone(constant) : constant;
		return nextConstant;
	}

	@Override
	public boolean hasNext() {
		return !isEvaluated;
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append("constant(");
		try {
			sb.append(constant.toString());
		} catch (Throwable e) {
			sb.append("???");
		}
		sb.append(")");
    }
}
