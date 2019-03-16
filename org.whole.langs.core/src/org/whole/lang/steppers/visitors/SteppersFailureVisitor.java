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
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator Whole
 */
public class SteppersFailureVisitor extends SteppersIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(Scope entity) {
        throw new VisitException();
    }

    public void visit(StepperApplication entity) {
        throw new VisitException();
    }

    public void visit(ResultAction entity) {
        throw new VisitException();
    }

    public void visit(Argument entity) {
        throw new VisitException();
    }

    public void visit(Declarations entity) {
        throw new VisitException();
    }

    public void visit(StepperDeclaration entity) {
        throw new VisitException();
    }

    public void visit(StepperReference entity) {
        throw new VisitException();
    }

    public void visit(Name entity) {
        throw new VisitException();
    }

    public void visit(Target entity) {
        throw new VisitException();
    }

    public void visit(Calls entity) {
        throw new VisitException();
    }

    public void visit(CallBranch entity) {
        throw new VisitException();
    }

    public void visit(Actions entity) {
        throw new VisitException();
    }

    public void visit(ActionBranch entity) {
        throw new VisitException();
    }

    public void visit(AndGoals entity) {
        throw new VisitException();
    }

    public void visit(OrGoals entity) {
        throw new VisitException();
    }

    public void visit(GoalBranch entity) {
        throw new VisitException();
    }

    public void visit(AndArgument entity) {
        throw new VisitException();
    }

    public void visit(OrArgument entity) {
        throw new VisitException();
    }

    public void visit(ArgumentBranch entity) {
        throw new VisitException();
    }
}
