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

import org.whole.lang.steppers.model.*;

/**
 *  @generator Whole
 */
public class SteppersIdentityDefaultVisitor extends SteppersIdentityVisitor {

    public void visit(ISteppersEntity entity) {
    }

    public void visit(Expression entity) {
    }

    public void visit(Scope entity) {
        visit((ISteppersEntity) entity);
        visit((Expression) entity);
    }

    public void visit(ResultAction entity) {
        visit((ISteppersEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Argument entity) {
        visit((ISteppersEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Declarations entity) {
        visit((ISteppersEntity) entity);
    }

    public void visit(Stepper entity) {
        visit((Expression) entity);
        visit((GoalFlow) entity);
        visit((CallFlow) entity);
        visit((ArgumentFlow) entity);
        visit((ActionFlow) entity);
    }

    public void visit(GoalFlow entity) {
    }

    public void visit(CallFlow entity) {
    }

    public void visit(ArgumentFlow entity) {
    }

    public void visit(ActionFlow entity) {
    }

    public void visit(StepperDeclaration entity) {
        visit((ISteppersEntity) entity);
        visit((Stepper) entity);
        visit((Declaration) entity);
    }

    public void visit(Declaration entity) {
    }

    public void visit(StepperReference entity) {
        visit((ISteppersEntity) entity);
        visit((Stepper) entity);
    }

    public void visit(Name entity) {
        visit((ISteppersEntity) entity);
    }

    public void visit(Target entity) {
        visit((ISteppersEntity) entity);
        visit((GoalFlow) entity);
        visit((ArgumentFlow) entity);
    }

    public void visit(Calls entity) {
        visit((ISteppersEntity) entity);
        visit((CallFlow) entity);
    }

    public void visit(CallBranch entity) {
        visit((ISteppersEntity) entity);
        visit((CallFlow) entity);
    }

    public void visit(Actions entity) {
        visit((ISteppersEntity) entity);
        visit((ActionFlow) entity);
    }

    public void visit(ActionBranch entity) {
        visit((ISteppersEntity) entity);
        visit((ActionFlow) entity);
    }

    public void visit(AndGoals entity) {
        visit((ISteppersEntity) entity);
        visit((GoalFlow) entity);
    }

    public void visit(OrGoals entity) {
        visit((ISteppersEntity) entity);
        visit((GoalFlow) entity);
    }

    public void visit(GoalBranch entity) {
        visit((ISteppersEntity) entity);
        visit((GoalFlow) entity);
    }

    public void visit(AndArgument entity) {
        visit((ISteppersEntity) entity);
        visit((ArgumentFlow) entity);
    }

    public void visit(OrArgument entity) {
        visit((ISteppersEntity) entity);
        visit((ArgumentFlow) entity);
    }

    public void visit(ArgumentBranch entity) {
        visit((ISteppersEntity) entity);
        visit((ArgumentFlow) entity);
    }
}
