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
package org.whole.lang.evaluators;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class PointwiseUpdateEvaluator extends AbstractPointwiseEvaluator {
	@SuppressWarnings("unchecked")
	public PointwiseUpdateEvaluator(IExecutable<IEntity> valuesExecutable, IExecutable<IEntity> toExecutable) {
		super(valuesExecutable, toExecutable);
	}

	protected IEntity apply(IEntity[] nestedResults) {
		if (BindingManagerFactory.instance.isVoid(nestedResults[0]))
			return nestedResults[0];

		IEntity result = EntityUtils.convertCloneIfParented(nestedResults[0], EntityUtils.getFormalType(nestedResults[1]));

		getProducer(1).set(result);

		return result;
	}

    @Override
	public void toString(StringBuilder sb) {
    	sb.append("update(");
    	getProducer(1).toString(sb);
    	sb.append(" .= ");
    	getProducer(0).toString(sb);
    	sb.append(")");
    }
}
