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

import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ChooseByOrderEvaluator extends AbstractDelegatingNestedEvaluator {
	protected boolean choosen;

	@SuppressWarnings("unchecked")
	public ChooseByOrderEvaluator(IExecutable... executables) {
		super(executables);
	}

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		choosen = false;
	}

	public IEntity evaluateNext() {
		IEntity result = null;

		if (choosen)
			result = getProducer().evaluateNext();
		else while (!choosen && isValidProducer()) {
			result = getProducer().evaluateNext();
			if (result != null)
				choosen = true;
			else
				selectFollowingProducer();
		}

		return lastEntity = result;
	}

//	public IEntity evaluateRemaining() {
//		IEntity result = null;
//
//		if (choosen)
//			result = getProducer().evaluateRemaining();
//		else while (!choosen && isValidProducer()) {
//			result = getProducer().evaluateRemaining();
//			if (result != null)
//				choosen = true;
//			else
//				selectFollowingProducer();
//		}
//
//		return result;
//	}

    @Override
	protected String toStringPrefix() {
		return "chooseByOrder(";
	}
    @Override
	protected String toStringSeparator() {
		return ",\n";
	}
}

