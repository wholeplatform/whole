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

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.steppers.model.*;

/**
 *  @generator Whole
 */
public interface ISteppersVisitor extends IVisitor {


    public void visit(Scope entity);

    public void visit(ResultAction entity);

    public void visit(Argument entity);

    public void visit(Declarations entity);

    public void visit(Step entity);

    public void visit(Choose entity);

    public void visit(StepperReference entity);

    public void visit(Name entity);

    public void visit(Target entity);

    public void visit(Calls entity);

    public void visit(CallBranch entity);

    public void visit(Actions entity);

    public void visit(ActionBranch entity);

    public void visit(AndGoals entity);

    public void visit(OrGoals entity);

    public void visit(GoalBranch entity);

    public void visit(AndArgument entity);

    public void visit(OrArgument entity);

    public void visit(ArgumentBranch entity);
}
