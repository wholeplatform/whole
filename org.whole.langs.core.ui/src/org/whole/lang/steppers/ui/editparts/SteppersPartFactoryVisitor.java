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
package org.whole.lang.steppers.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.steppers.model.ActionBranch;
import org.whole.lang.steppers.model.Actions;
import org.whole.lang.steppers.model.AndArgument;
import org.whole.lang.steppers.model.AndGoals;
import org.whole.lang.steppers.model.Argument;
import org.whole.lang.steppers.model.ArgumentBranch;
import org.whole.lang.steppers.model.CallBranch;
import org.whole.lang.steppers.model.Calls;
import org.whole.lang.steppers.model.GoalBranch;
import org.whole.lang.steppers.model.ISteppersEntity;
import org.whole.lang.steppers.model.Name;
import org.whole.lang.steppers.model.OrArgument;
import org.whole.lang.steppers.model.OrGoals;
import org.whole.lang.steppers.model.StepperApplication;
import org.whole.lang.steppers.model.StepperDeclaration;
import org.whole.lang.steppers.model.StepperReference;
import org.whole.lang.steppers.model.Target;
import org.whole.lang.steppers.visitors.SteppersIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.ContentDataEntityPart;
import org.whole.lang.ui.editparts.ContentLightTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IdentifierTextualEntityPart;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;

/**
 *  @generator Whole
 */
public class SteppersPartFactoryVisitor extends SteppersIdentityDefaultVisitor implements IEditPartFactory {
    protected EditPart part, context;

    public EditPart createEditPart(EditPart context, Object modelEntity) {
        this.context = context;
        ((ISteppersEntity) modelEntity).accept(this);
        return part;
    }

    public void visit(ISteppersEntity entity) {
        part = TablePartFactory.instance().createEditPart(context, entity);
    }

    @Override
    public void visit(StepperApplication entity) {
        part = new StepperApplicationPart();
    }

    @Override
    public void visit(Argument entity) {
        part = new ContentDataEntityPart();
    }

    @Override
    public void visit(StepperDeclaration entity) {
        part = new StepperDeclarationPart();
    }

    @Override
    public void visit(StepperReference entity) {
        part = new IdentifierTextualEntityPart();
    }

    @Override
    public void visit(Name entity) {
        part = new ContentLightTextualEntityPart();
    }

    @Override
    public void visit(Target entity) {
        part = new TargetPart();
    }

    @Override
    public void visit(Calls entity) {
        part = new CallsPart();
    }

    @Override
    public void visit(CallBranch entity) {
        part = new CallBranchPart();
    }

    @Override
    public void visit(Actions entity) {
        part = new ActionsPart();
    }

    @Override
    public void visit(ActionBranch entity) {
        part = new ActionBranchPart();
    }

    @Override
    public void visit(AndGoals entity) {
        part = new AndGoalsPart();
    }

    @Override
    public void visit(OrGoals entity) {
        part = new OrGoalsPart();
    }

    @Override
    public void visit(GoalBranch entity) {
        part = new GoalBranchPart();
    }

    @Override
    public void visit(AndArgument entity) {
        part = new AndArgumentPart();
    }

    @Override
    public void visit(OrArgument entity) {
        part = new OrArgumentPart();
    }

    @Override
    public void visit(ArgumentBranch entity) {
        part = new ArgumentBranchPart();
    }
}
