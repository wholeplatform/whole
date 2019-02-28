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
package org.whole.lang.steppers.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class SteppersImplEntityRegistry extends AbstractEntityRegistry {

    public SteppersImplEntityRegistry() {
        super(SteppersEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new StepperApplicationImpl());
        put(new ArgumentImpl());
        put(new StepperDeclarationImpl());
        put(new StepperReferenceImpl());
        put(new NameImpl());
        put(new TargetImpl());
        put(new CallsImpl());
        put(new CallBranchImpl());
        put(new ActionsImpl());
        put(new ActionBranchImpl());
        put(new AndGoalsImpl());
        put(new OrGoalsImpl());
        put(new GoalBranchImpl());
        put(new AndArgumentImpl());
        put(new OrArgumentImpl());
        put(new ArgumentBranchImpl());
    }
}
