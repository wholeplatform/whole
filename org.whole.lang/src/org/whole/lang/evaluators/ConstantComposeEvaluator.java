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

import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ConstantComposeEvaluator extends AbstractDelegatingNestedEvaluator {
	protected IEntity constant;

	public ConstantComposeEvaluator(IEntity constant, IExecutable executable) {
		super(executable);
		this.constant = constant;
		executable.reset(constant);
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(constant);
	}

	@Override
	public IEntity evaluateNext() {
		return getProducer().evaluateNext();
	}

	@Override
	public IEntity evaluateRemaining() {
		return getProducer().evaluateRemaining();
	}
}
