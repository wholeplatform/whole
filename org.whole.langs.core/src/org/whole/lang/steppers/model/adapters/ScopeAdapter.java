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

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.steppers.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.steppers.visitors.ISteppersVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.steppers.reflect.SteppersFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ScopeAdapter extends AbstractEntityAdapter implements Scope {
    private static final long serialVersionUID = 1;

    public ScopeAdapter(IEntity implementor) {
        super(implementor);
    }

    public ScopeAdapter() {
    }

    public void accept(ISteppersVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Scope> wGetEntityDescriptor() {
        return SteppersEntityDescriptorEnum.Scope;
    }

    public Declarations getDeclarations() {
        return wGet(SteppersFeatureDescriptorEnum.declarations).wGetAdapter(SteppersEntityDescriptorEnum.Declarations);
    }

    public void setDeclarations(Declarations declarations) {
        wSet(SteppersFeatureDescriptorEnum.declarations, declarations);
    }

    public Expression getExpression() {
        return wGet(SteppersFeatureDescriptorEnum.expression).wGetAdapter(SteppersEntityDescriptorEnum.Expression);
    }

    public void setExpression(Expression expression) {
        wSet(SteppersFeatureDescriptorEnum.expression, expression);
    }
}
