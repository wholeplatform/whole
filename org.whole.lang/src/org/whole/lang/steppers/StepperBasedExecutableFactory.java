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
	public <E extends IEntity> IExecutable<E> createConstantChild(IEntity constant) {
		return new ConstantChildStepper<E>(true, constant);
	}
	public <E extends IEntity> IExecutable<E> createConstantCompose(IEntity constant, IExecutable<E> executable) {
		return new ConstantComposeStepper<E>(constant, executable);
	}

	public <E extends IEntity> IExecutable<E> createChild() {
		return new ChildStepper<E>(true);
	}
	public <E extends IEntity> IExecutable<E> createChild(int relativeFirstIndex) {
		return new ChildStepper<E>(true, relativeFirstIndex);
	}
	public <E extends IEntity> IExecutable<E> createChildReverse() {
		return new ChildStepper<E>(false);
	}
	public <E extends IEntity> IExecutable<E> createChildReverse(int relativeFirstIndex) {
		return new ChildStepper<E>(false, relativeFirstIndex);
	}
	public <E extends IEntity> IExecutable<E> createChildRange(int relativeStartIndex, int relativeEndIndex) {
		return new ChildRangeStepper<E>(true, relativeStartIndex, relativeEndIndex);
	}

	public <E extends IEntity> IExecutable<E> createFollowingSibling() {
		return new FollowingSiblingStepper<E>(true, false);
	}
	public <E extends IEntity> IExecutable<E> createFollowingSiblingReverse() {
		return new FollowingSiblingStepper<E>(false, false);
	}
	public <E extends IEntity> IExecutable<E> createPrecedingSibling() {
		return new PrecedingSiblingStepper<E>(false, false);
	}
	public <E extends IEntity> IExecutable<E> createPrecedingSiblingReverse() {
		return new PrecedingSiblingStepper<E>(true, false);
	}

	public <E extends IEntity> IExecutable<E> createFollowingSiblingOrSelf() {
		return new FollowingSiblingStepper<E>(true, true);
	}
	public <E extends IEntity> IExecutable<E> createFollowingSiblingOrSelfReverse() {
		return new FollowingSiblingStepper<E>(false, true);
	}
	public <E extends IEntity> IExecutable<E> createPrecedingSiblingOrSelf() {
		return new PrecedingSiblingStepper<E>(false, true);
	}
	public <E extends IEntity> IExecutable<E> createPrecedingSiblingOrSelfReverse() {
		return new PrecedingSiblingStepper<E>(true, true);
	}

	public <E extends IEntity> IExecutable<E> createAdjacent() {
		return new AdjacentStepper<E>(true);
	}
	public <E extends IEntity> IExecutable<E> createAdjacent(int relativeFirstIndex) {
		return new AdjacentStepper<E>(true, relativeFirstIndex);
	}
	public <E extends IEntity> IExecutable<E> createAdjacentReverse() {
		return new AdjacentStepper<E>(false);
	}

	public <E extends IEntity> IExecutable<E> createChildOrAdjacent() {
		return new ChildOrAdjacentStepper<E>(true);
	}
	public <E extends IEntity> IExecutable<E> createChildOrAdjacent(int relativeFirstIndex) {
		return new ChildOrAdjacentStepper<E>(true, relativeFirstIndex);
	}


	@SuppressWarnings("unchecked")
	public <E extends IEntity> IExecutable<E> createIf(IExecutable<? extends IEntity> conditionExecutable, IExecutable<E> doExecutable) {
		return super.createIf(conditionExecutable, doExecutable);
//FIXME
//		return (IExecutable<E>) new IfStepper((IExecutable<IEntity>) conditionExecutable, (IExecutable<IEntity>) doExecutable);
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IExecutable<E> createChoose(IExecutable<? extends E>... executableChain) {
		return super.createChoose(executableChain);
//FIXME
//		return new ChooseByOrderStepper<E>(executableChain);
	}

	public <E extends IEntity> IExecutable<E> createSequence(IExecutable<? extends E>... executableChain) {
		return super.createSequence(executableChain);
//FIXME
//		return new SequenceStepper<E>(executableChain);
	}
}
