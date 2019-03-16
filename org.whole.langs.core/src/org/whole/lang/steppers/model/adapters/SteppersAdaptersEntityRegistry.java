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
package org.whole.lang.steppers.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class SteppersAdaptersEntityRegistry extends AbstractEntityRegistry {

    public SteppersAdaptersEntityRegistry() {
        super(SteppersEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new ExpressionAdapter());
        put(new ScopeAdapter());
        put(new StepperApplicationAdapter());
        put(new ResultActionAdapter());
        put(new ArgumentAdapter());
        put(new DeclarationsAdapter());
        put(new DeclarationAdapter());
        put(new StepperAdapter());
        put(new StepperDeclarationAdapter());
        put(new StepperReferenceAdapter());
        put(new NameAdapter());
        put(new TargetAdapter());
        put(new CallFlowAdapter());
        put(new CallsAdapter());
        put(new CallBranchAdapter());
        put(new ActionFlowAdapter());
        put(new ActionsAdapter());
        put(new ActionBranchAdapter());
        put(new GoalFlowAdapter());
        put(new AndGoalsAdapter());
        put(new OrGoalsAdapter());
        put(new GoalBranchAdapter());
        put(new ArgumentFlowAdapter());
        put(new AndArgumentAdapter());
        put(new OrArgumentAdapter());
        put(new ArgumentBranchAdapter());
    }
}
