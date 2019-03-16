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
package org.whole.lang.steppers.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.steppers.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SteppersForwardStrategyVisitor extends GenericForwardStrategyVisitor<ISteppersVisitor> implements ISteppersVisitor {

    public SteppersForwardStrategyVisitor() {
        this(new SteppersIdentityVisitor());
    }

    public SteppersForwardStrategyVisitor(ISteppersVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((ISteppersEntity) entity).accept(this);
    }

    public void visit(Scope entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StepperApplication entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ResultAction entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Argument entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Declarations entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StepperDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StepperReference entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Name entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Target entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Calls entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CallBranch entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Actions entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ActionBranch entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AndGoals entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OrGoals entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GoalBranch entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AndArgument entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OrArgument entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArgumentBranch entity) {
        wGetStrategy().visit(entity);
    }
}
