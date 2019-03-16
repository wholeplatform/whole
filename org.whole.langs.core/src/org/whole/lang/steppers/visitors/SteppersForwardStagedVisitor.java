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
public class SteppersForwardStagedVisitor extends SteppersIdentityVisitor {

    public void visit(Scope entity) {
        stagedVisit(entity);
    }

    public void visit(ResultAction entity) {
        stagedVisit(entity);
    }

    public void visit(Argument entity) {
        stagedVisit(entity);
    }

    public void visit(Declarations entity) {
        stagedVisit(entity);
    }

    public void visit(StepperDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(StepperReference entity) {
        stagedVisit(entity);
    }

    public void visit(Name entity) {
        stagedVisit(entity);
    }

    public void visit(Target entity) {
        stagedVisit(entity);
    }

    public void visit(Calls entity) {
        stagedVisit(entity);
    }

    public void visit(CallBranch entity) {
        stagedVisit(entity);
    }

    public void visit(Actions entity) {
        stagedVisit(entity);
    }

    public void visit(ActionBranch entity) {
        stagedVisit(entity);
    }

    public void visit(AndGoals entity) {
        stagedVisit(entity);
    }

    public void visit(OrGoals entity) {
        stagedVisit(entity);
    }

    public void visit(GoalBranch entity) {
        stagedVisit(entity);
    }

    public void visit(AndArgument entity) {
        stagedVisit(entity);
    }

    public void visit(OrArgument entity) {
        stagedVisit(entity);
    }

    public void visit(ArgumentBranch entity) {
        stagedVisit(entity);
    }
}
