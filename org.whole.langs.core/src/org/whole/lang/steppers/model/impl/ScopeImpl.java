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

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.steppers.model.Scope;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.steppers.visitors.ISteppersVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.steppers.model.Declarations;
import org.whole.lang.steppers.reflect.SteppersFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.steppers.model.Expression;

/**
 *  @generator Whole
 */
public class ScopeImpl extends AbstractSimpleEntity implements Scope {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Scope> wGetEntityDescriptor() {
        return SteppersEntityDescriptorEnum.Scope;
    }

    public int wGetEntityOrd() {
        return SteppersEntityDescriptorEnum.Scope_ord;
    }

    public void accept(ISteppersVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Declarations declarations;

    public Declarations getDeclarations() {
        return notifyRequested(SteppersFeatureDescriptorEnum.declarations, declarations);
    }

    public void setDeclarations(Declarations declarations) {
        notifyChanged(SteppersFeatureDescriptorEnum.declarations, this.declarations, this.declarations = declarations);
    }
    private Expression expression;

    public Expression getExpression() {
        return notifyRequested(SteppersFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(Expression expression) {
        notifyChanged(SteppersFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getDeclarations().wGetAdaptee(false);
            case 1 :
            return getExpression().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setDeclarations(value.wGetAdapter(SteppersEntityDescriptorEnum.Declarations));
            break;
            case 1 :
            setExpression(value.wGetAdapter(SteppersEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
