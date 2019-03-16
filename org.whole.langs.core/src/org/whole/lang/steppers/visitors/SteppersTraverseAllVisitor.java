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
import org.whole.lang.steppers.visitors.ISteppersVisitor;
import org.whole.lang.steppers.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class SteppersTraverseAllVisitor extends SteppersIdentityUnaryVisitor<ISteppersVisitor> {

    public SteppersTraverseAllVisitor() {
        wSetVisitor1(this);
    }

    public SteppersTraverseAllVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Scope entity) {
        entity.getDeclarations().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(ResultAction entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getActions().accept(wGetVisitor1());
    }

    public void visit(Declarations entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(StepperDeclaration entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getGoals().accept(wGetVisitor1());
        entity.getCalls().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
        entity.getActions().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Calls entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(CallBranch entity) {
        entity.getGoals().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
    }

    public void visit(Actions entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ActionBranch entity) {
        entity.getGoals().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
    }

    public void visit(AndGoals entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(OrGoals entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(GoalBranch entity) {
        entity.getCalls().accept(wGetVisitor1());
        entity.getActions().accept(wGetVisitor1());
    }

    public void visit(AndArgument entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(OrArgument entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ArgumentBranch entity) {
        entity.getCalls().accept(wGetVisitor1());
        entity.getActions().accept(wGetVisitor1());
    }
}
