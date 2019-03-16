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

import org.whole.lang.steppers.visitors.SteppersIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.steppers.model.*;

/**
 *  @generator Whole
 */
public class SteppersTraverseAllSwitchVisitor extends SteppersIdentityUnaryVisitor<IVisitor> {

    public SteppersTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Scope entity) {
        wGetVisitor1().visit(entity.getDeclarations());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(StepperApplication entity) {
        wGetVisitor1().visit(entity.getGoals());
        wGetVisitor1().visit(entity.getResults());
    }

    public void visit(ResultAction entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getActions());
    }

    public void visit(Declarations entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(StepperDeclaration entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getGoals());
        wGetVisitor1().visit(entity.getCalls());
        wGetVisitor1().visit(entity.getArguments());
        wGetVisitor1().visit(entity.getActions());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Calls entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(CallBranch entity) {
        wGetVisitor1().visit(entity.getGoals());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(Actions entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ActionBranch entity) {
        wGetVisitor1().visit(entity.getGoals());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(AndGoals entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(OrGoals entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(GoalBranch entity) {
        wGetVisitor1().visit(entity.getCalls());
        wGetVisitor1().visit(entity.getActions());
    }

    public void visit(AndArgument entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(OrArgument entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ArgumentBranch entity) {
        wGetVisitor1().visit(entity.getCalls());
        wGetVisitor1().visit(entity.getActions());
    }
}
