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
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.steppers.model.ActionBranch;
import org.whole.lang.steppers.model.Actions;
import org.whole.lang.steppers.model.AndArgument;
import org.whole.lang.steppers.model.AndGoals;
import org.whole.lang.steppers.model.Argument;
import org.whole.lang.steppers.model.ArgumentBranch;
import org.whole.lang.steppers.model.CallBranch;
import org.whole.lang.steppers.model.Calls;
import org.whole.lang.steppers.model.Choose;
import org.whole.lang.steppers.model.GoalBranch;
import org.whole.lang.steppers.model.ISteppersEntity;
import org.whole.lang.steppers.model.Name;
import org.whole.lang.steppers.model.OrArgument;
import org.whole.lang.steppers.model.OrGoals;
import org.whole.lang.steppers.model.ResultAction;
import org.whole.lang.steppers.model.Scope;
import org.whole.lang.steppers.model.Step;
import org.whole.lang.steppers.model.StepperReference;
import org.whole.lang.steppers.model.Target;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.steppers.reflect.SteppersFeatureDescriptorEnum;
import org.whole.lang.steppers.visitors.SteppersIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.ContentLightTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.VariableDataEntityPart;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;
import org.whole.lang.util.EntityUtils;

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

	protected boolean inArgumentsFlow() {
		return ((IEntityPart) context).isReversed();
	}

    public void visit(ISteppersEntity entity) {
        part = TablePartFactory.instance().createEditPart(context, entity);
    }

    @Override
    public void visit(Scope entity) {
    	part = new ScopePart();
    }

    @Override
    public void visit(Argument entity) {
        part = new ArgumentPart();
    }

    @Override
    public void visit(Step entity) {
        part = new StepPart();
    }

    @Override
    public void visit(Choose entity) {
        part = new ChoosePart();
    }

    @Override
    public void visit(StepperReference entity) {
        part = new ContentLightTextualEntityPart();
    }

    @Override
    public void visit(ResultAction entity) {
    	// TODO Auto-generated method stub
    	super.visit(entity);
    }

    @Override
    public void visit(Name entity) {
    	if (EntityUtils.hasParent(entity)) {
    		IEntity parent = entity.wGetParent();
    		if (parent.wGetEntityDescriptor().equals(SteppersEntityDescriptorEnum.Choose)) {
    			part = new VariableDataEntityPart();
    			return;
    		}
    	}
        part = new ContentLightTextualEntityPart();
    }

    @Override
    public void visit(Target entity) {
        part = new TargetPart();
    }

    @Override
    public void visit(Calls entity) {
    	IEntity parent = entity.wGetParent();

        if (!EntityUtils.isNull(parent)) {
    		if (parent.wGetEntityDescriptor().equals(SteppersEntityDescriptorEnum.Choose)) {
    	        part = new ObliqueTreePart(Matcher.matchAtEntityFeature(SteppersEntityDescriptorEnum.CallBranch, SteppersFeatureDescriptorEnum.arguments, entity) || inArgumentsFlow(), true);
    			return;
    		}
    	}

    	part = new ObliqueTreePart((!EntityUtils.isNull(parent) && Matcher.matchAtEntityFeature(SteppersEntityDescriptorEnum.CallBranch, SteppersFeatureDescriptorEnum.arguments, entity)) || inArgumentsFlow());
    }
    @Override
    public void visit(Actions entity) {
    	IEntity parent = entity.wGetParent();
        part = new ObliqueTreePart((!EntityUtils.isNull(parent) && Matcher.matchAtEntityFeature(SteppersEntityDescriptorEnum.ActionBranch, SteppersFeatureDescriptorEnum.arguments, entity)) || inArgumentsFlow());
    }

    @Override
    public void visit(CallBranch entity) {
        part = new CallGoalsWithArgumentsPart();
    }
    @Override
    public void visit(ActionBranch entity) {
        part = new ActionGoalsWithArgumentsPart();
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
