/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.steppers.builders;

import org.whole.lang.builders.IBuilder;

/**
 *  @generator Whole
 */
public interface ISteppersBuilder extends IBuilder {


    public void visit();

    public void expression();

    public void actions();

    public void calls();

    public void name();

    public void arguments();

    public void goals();

    public void StepperApplication();

    public void StepperApplication_();

    public void _StepperApplication();

    public void Argument();

    public void Argument(int value);

    public void StepperDeclaration();

    public void StepperDeclaration_();

    public void _StepperDeclaration();

    public void StepperReference();

    public void StepperReference(String value);

    public void Name();

    public void Name(String value);

    public void Target();

    public void Target_();

    public void _Target();

    public void Calls();

    public void Calls_();

    public void Calls_(int initialCapacity);

    public void _Calls();

    public void CallBranch();

    public void CallBranch_();

    public void _CallBranch();

    public void Actions();

    public void Actions_();

    public void Actions_(int initialCapacity);

    public void _Actions();

    public void ActionBranch();

    public void ActionBranch_();

    public void _ActionBranch();

    public void AndGoals();

    public void AndGoals_();

    public void AndGoals_(int initialCapacity);

    public void _AndGoals();

    public void OrGoals();

    public void OrGoals_();

    public void OrGoals_(int initialCapacity);

    public void _OrGoals();

    public void GoalBranch();

    public void GoalBranch_();

    public void _GoalBranch();

    public void AndArgument();

    public void AndArgument_();

    public void AndArgument_(int initialCapacity);

    public void _AndArgument();

    public void OrArgument();

    public void OrArgument_();

    public void OrArgument_(int initialCapacity);

    public void _OrArgument();

    public void ArgumentBranch();

    public void ArgumentBranch_();

    public void _ArgumentBranch();
}
