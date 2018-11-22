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
import org.whole.lang.executables.Placement;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class CartesianInsertEvaluator extends AbstractCartesianEvaluator {
	protected Placement placement;

	public CartesianInsertEvaluator(IExecutable toExecutable, IExecutable valuesExecutable, Placement placement) {
		super(toExecutable, valuesExecutable);
		this.placement = placement;
	}

	protected IEntity evaluateNestedResults() {
		if (isNotLastProducer())
			return null;

		if (BindingManagerFactory.instance.isVoid(nestedResults[1]))
			return nestedResults[1];

		EntityDescriptor<?> toEd;
		switch (placement) {
		case BEFORE:
			toEd = nestedResults[0].wGetParent().wGetEntityDescriptor(nestedResults[0]);
			break;
		case INTO:
			//TODO workaround for Resolver ED
			if (EntityUtils.isResolver(nestedResults[0]))
				toEd = nestedResults[0].wGetParent().wGetEntityDescriptor(nestedResults[0]).getEntityDescriptor(0);
			else
				toEd = nestedResults[0].wGetEntityDescriptor(0);
			break;
		default:
			throw new IllegalArgumentException("unsupported placement");
		}
		IEntity result = EntityUtils.convertCloneIfParented(nestedResults[1], toEd);

		switch (placement) {
		case BEFORE:
			getProducer(0).add(result);
			break;
		case INTO:
			nestedResults[0].wAdd(result);
			break;
		}

		return result;
	}

	@Override
	public void prune() {
		if (isValidResultProducer())
			getProducer(0).prune();
	}

	public void set(IEntity entity) {
    	if (!isValidResultProducer())
    		throw new IllegalStateException();

    	getProducer(0).set(entity);
	}
	public void add(IEntity entity) {
    	if (!isValidResultProducer())
    		throw new IllegalStateException();

		getProducer(0).add(entity);
	}
	public void remove() {
    	if (!isValidResultProducer())
    		throw new IllegalStateException();

		getProducer(0).remove();
	}

	@Override
	protected String toStringPrefix() {
		return "insert"+placement+"(";
	}
	@Override
	protected String toStringSeparator() {
		return " x= ";
	}
}
