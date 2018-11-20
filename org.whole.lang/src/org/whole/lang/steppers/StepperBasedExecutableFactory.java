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
package org.whole.lang.steppers;

import org.whole.lang.executables.IExecutable;
import org.whole.lang.executables.RegularExecutableFactory;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class StepperBasedExecutableFactory extends RegularExecutableFactory {
	public IExecutable createConstantChild(IEntity constant) {
		return new ConstantChildStepper(true, constant);
	}
	public IExecutable createConstantCompose(IEntity constant, IExecutable executable) {
		return new ConstantComposeStepper(constant, (IExecutable) executable);
	}

	public IExecutable createChild() {
		return new ChildStepper(true);
	}
	public IExecutable createChild(int relativeFirstIndex) {
		return new ChildStepper(true, relativeFirstIndex);
	}
	public IExecutable createChildReverse() {
		return new ChildStepper(false);
	}
	public IExecutable createChildReverse(int relativeFirstIndex) {
		return new ChildStepper(false, relativeFirstIndex);
	}
	public IExecutable createChildRange(int relativeStartIndex, int relativeEndIndex) {
		return new ChildRangeStepper(true, relativeStartIndex, relativeEndIndex);
	}

	public IExecutable createFollowingSibling() {
		return new FollowingSiblingStepper(true, false);
	}
	public IExecutable createFollowingSiblingReverse() {
		return new FollowingSiblingStepper(false, false);
	}
	public IExecutable createPrecedingSibling() {
		return new PrecedingSiblingStepper(false, false);
	}
	public IExecutable createPrecedingSiblingReverse() {
		return new PrecedingSiblingStepper(true, false);
	}

	public IExecutable createFollowingSiblingOrSelf() {
		return new FollowingSiblingStepper(true, true);
	}
	public IExecutable createFollowingSiblingOrSelfReverse() {
		return new FollowingSiblingStepper(false, true);
	}
	public IExecutable createPrecedingSiblingOrSelf() {
		return new PrecedingSiblingStepper(false, true);
	}
	public IExecutable createPrecedingSiblingOrSelfReverse() {
		return new PrecedingSiblingStepper(true, true);
	}

	public IExecutable createAdjacent() {
		return new AdjacentStepper(true);
	}
	public IExecutable createAdjacent(int relativeFirstIndex) {
		return new AdjacentStepper(true, relativeFirstIndex);
	}
	public IExecutable createAdjacentReverse() {
		return new AdjacentStepper(false);
	}

	public IExecutable createChildOrAdjacent() {
		return new ChildOrAdjacentStepper(true);
	}
	public IExecutable createChildOrAdjacent(int relativeFirstIndex) {
		return new ChildOrAdjacentStepper(true, relativeFirstIndex);
	}


	@SuppressWarnings("unchecked")
	public IExecutable createIf(IExecutable conditionExecutable, IExecutable doExecutable) {
		return super.createIf(conditionExecutable, doExecutable);
//FIXME
//		return (IExecutable) new IfStepper((IExecutable) conditionExecutable, (IExecutable) doExecutable);
	}

	@SuppressWarnings("unchecked")
	public IExecutable createChoose(IExecutable... executableChain) {
		return super.createChoose(executableChain);
//FIXME
//		return new ChooseByOrderStepper(executableChain);
	}

	public IExecutable createSequence(IExecutable... executableChain) {
		return super.createSequence(executableChain);
//FIXME
//		return new SequenceStepper(executableChain);
	}
}
