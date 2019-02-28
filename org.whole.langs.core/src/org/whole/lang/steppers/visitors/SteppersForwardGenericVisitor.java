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

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.steppers.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SteppersForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements ISteppersVisitor {

    public SteppersForwardGenericVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(StepperApplication entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Argument entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(StepperDeclaration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(StepperReference entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Name entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Target entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Calls entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CallBranch entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Actions entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ActionBranch entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AndGoals entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OrGoals entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(GoalBranch entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AndArgument entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OrArgument entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ArgumentBranch entity) {
        wGetVisitor1().visit(entity);
    }
}
