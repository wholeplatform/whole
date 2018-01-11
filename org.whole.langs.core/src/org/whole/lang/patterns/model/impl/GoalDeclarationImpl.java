/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.GoalDeclaration;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.patterns.model.GoalExpression;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.model.Name;
import org.whole.lang.patterns.model.Expression;

/**
 *  @generator Whole
 */
public class GoalDeclarationImpl extends AbstractSimpleEntity implements GoalDeclaration {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<GoalDeclaration> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.GoalDeclaration;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.GoalDeclaration_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private GoalExpression subgoals;

    public GoalExpression getSubgoals() {
        return notifyRequested(PatternsFeatureDescriptorEnum.subgoals, subgoals);
    }

    public void setSubgoals(GoalExpression subgoals) {
        notifyChanged(PatternsFeatureDescriptorEnum.subgoals, this.subgoals, this.subgoals = subgoals);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(PatternsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(PatternsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Expression body;

    public Expression getBody() {
        return notifyRequested(PatternsFeatureDescriptorEnum.body, body);
    }

    public void setBody(Expression body) {
        notifyChanged(PatternsFeatureDescriptorEnum.body, this.body, this.body = body);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSubgoals().wGetAdaptee(false);
            case 1 :
            return getName().wGetAdaptee(false);
            case 2 :
            return getBody().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSubgoals(value.wGetAdapter(PatternsEntityDescriptorEnum.GoalExpression));
            break;
            case 1 :
            setName(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            case 2 :
            setBody(value.wGetAdapter(PatternsEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
