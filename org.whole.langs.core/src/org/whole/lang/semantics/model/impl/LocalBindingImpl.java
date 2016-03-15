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
package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.LocalBinding;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.semantics.model.BindingOp;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.model.LocalIdentifier;
import org.whole.lang.semantics.model.Expression;

/**
 *  @generator Whole
 */
public class LocalBindingImpl extends AbstractSimpleEntity implements LocalBinding {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<LocalBinding> wGetEntityDescriptor() {
        return SemanticsEntityDescriptorEnum.LocalBinding;
    }

    public int wGetEntityOrd() {
        return SemanticsEntityDescriptorEnum.LocalBinding_ord;
    }

    public void accept(ISemanticsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private BindingOp op;

    public BindingOp getOp() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.op, op);
    }

    public void setOp(BindingOp op) {
        notifyChanged(SemanticsFeatureDescriptorEnum.op, this.op, this.op = op);
    }

    public int wHashCode() {
        return getIdentifier().wHashCode();
    }

    public boolean wEquals(IEntity entity) {
        if (this == entity)
            return true;
        if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
            return false;
        try {
            return getIdentifier().wEquals(entity.wGet(SemanticsFeatureDescriptorEnum.identifier));
        } catch (Exception e) {
            return false;
        }
    }

    protected void toString(StringBuffer buffer) {
        buffer.append("identifier=");
        buffer.append(identifier);
    }
    private LocalIdentifier identifier;

    public LocalIdentifier getIdentifier() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.identifier, identifier);
    }

    public void setIdentifier(LocalIdentifier identifier) {
        notifyChanged(SemanticsFeatureDescriptorEnum.identifier, this.identifier, this.identifier = identifier);
    }
    private Expression expression;

    public Expression getExpression() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(Expression expression) {
        notifyChanged(SemanticsFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getOp().wGetAdaptee(false);
            case 1 :
            return getIdentifier().wGetAdaptee(false);
            case 2 :
            return getExpression().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setOp(value.wGetAdapter(SemanticsEntityDescriptorEnum.BindingOp));
            break;
            case 1 :
            setIdentifier(value.wGetAdapter(SemanticsEntityDescriptorEnum.LocalIdentifier));
            break;
            case 2 :
            setExpression(value.wGetAdapter(SemanticsEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
