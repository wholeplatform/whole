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
import org.whole.lang.iterators.Placement;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class PointwiseInsertEvaluator extends AbstractPointwiseEvaluator {
	protected Placement placement;

	@SuppressWarnings("unchecked")
	public PointwiseInsertEvaluator(IExecutable<IEntity> valuesExecutable, IExecutable<IEntity> toExecutable, Placement placement) {
		super(valuesExecutable, toExecutable);
		this.placement = placement;
	}

	protected IEntity apply(IEntity[] nestedResults) {
		if (BindingManagerFactory.instance.isVoid(nestedResults[0]))
			return nestedResults[0];

		EntityDescriptor<?> toEd;
		switch (placement) {
		case BEFORE:
			toEd = nestedResults[1].wGetParent().wGetEntityDescriptor(nestedResults[1]);
			break;
		case INTO:
			//TODO workaround for Resolver ED
			if (EntityUtils.isResolver(nestedResults[1]))
				toEd = nestedResults[1].wGetParent().wGetEntityDescriptor(nestedResults[1]).getEntityDescriptor(0);
			else
				toEd = nestedResults[1].wGetEntityDescriptor(0);
			break;
		default:
			throw new IllegalArgumentException("unsupported placement");
		}
		IEntity result = EntityUtils.convertCloneIfParented(nestedResults[0], toEd);

		switch (placement) {
		case BEFORE:
			getProducer(1).add(result);
			break;
		case INTO:
			nestedResults[1].wAdd(result);
			break;
		}

		return result;
	}

    @Override
	public void toString(StringBuilder sb) {
    	sb.append("insert");
    	sb.append(placement);
    	sb.append("(");
    	getProducer(1).toString(sb);
    	sb.append(" .= ");
    	getProducer(0).toString(sb);
    	sb.append(")");
    }
}
