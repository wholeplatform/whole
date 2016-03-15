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
package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class GoalDeclarationAdapter extends AbstractEntityAdapter implements GoalDeclaration {
    private static final long serialVersionUID = 1;

    public GoalDeclarationAdapter(IEntity implementor) {
        super(implementor);
    }

    public GoalDeclarationAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<GoalDeclaration> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.GoalDeclaration;
    }

    public GoalExpression getSubgoals() {
        return wGet(PatternsFeatureDescriptorEnum.subgoals).wGetAdapter(PatternsEntityDescriptorEnum.GoalExpression);
    }

    public void setSubgoals(GoalExpression subgoals) {
        wSet(PatternsFeatureDescriptorEnum.subgoals, subgoals);
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public PathExpression getBody() {
        return wGet(PatternsFeatureDescriptorEnum.body).wGetAdapter(PatternsEntityDescriptorEnum.PathExpression);
    }

    public void setBody(PathExpression body) {
        wSet(PatternsFeatureDescriptorEnum.body, body);
    }
}
