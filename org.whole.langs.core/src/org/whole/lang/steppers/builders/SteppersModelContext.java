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
package org.whole.lang.steppers.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.steppers.reflect.SteppersFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class SteppersModelContext extends EntityContext {

    public SteppersModelContext(IEntity root) {
        super(root);
    }

    public SteppersModelContext getDeclarations() {
        return (SteppersModelContext) wGet(SteppersFeatureDescriptorEnum.declarations);
    }

    public void setDeclarations(SteppersModelContext declarations) {
        wSet(SteppersFeatureDescriptorEnum.declarations, declarations);
    }

    public SteppersModelContext getExpression() {
        return (SteppersModelContext) wGet(SteppersFeatureDescriptorEnum.expression);
    }

    public void setExpression(SteppersModelContext expression) {
        wSet(SteppersFeatureDescriptorEnum.expression, expression);
    }

    public SteppersModelContext getGoals() {
        return (SteppersModelContext) wGet(SteppersFeatureDescriptorEnum.goals);
    }

    public void setGoals(SteppersModelContext goals) {
        wSet(SteppersFeatureDescriptorEnum.goals, goals);
    }

    public SteppersModelContext getResults() {
        return (SteppersModelContext) wGet(SteppersFeatureDescriptorEnum.results);
    }

    public void setResults(SteppersModelContext results) {
        wSet(SteppersFeatureDescriptorEnum.results, results);
    }

    public SteppersModelContext getActions() {
        return (SteppersModelContext) wGet(SteppersFeatureDescriptorEnum.actions);
    }

    public void setActions(SteppersModelContext actions) {
        wSet(SteppersFeatureDescriptorEnum.actions, actions);
    }

    public SteppersModelContext getName() {
        return (SteppersModelContext) wGet(SteppersFeatureDescriptorEnum.name);
    }

    public void setName(SteppersModelContext name) {
        wSet(SteppersFeatureDescriptorEnum.name, name);
    }

    public SteppersModelContext getCalls() {
        return (SteppersModelContext) wGet(SteppersFeatureDescriptorEnum.calls);
    }

    public void setCalls(SteppersModelContext calls) {
        wSet(SteppersFeatureDescriptorEnum.calls, calls);
    }

    public SteppersModelContext getArguments() {
        return (SteppersModelContext) wGet(SteppersFeatureDescriptorEnum.arguments);
    }

    public void setArguments(SteppersModelContext arguments) {
        wSet(SteppersFeatureDescriptorEnum.arguments, arguments);
    }
}
