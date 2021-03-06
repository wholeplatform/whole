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
package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.OutputBinding;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.semantics.model.BindingSubject;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.model.Expression;

/**
 *  @generator Whole
 */
public class OutputBindingImpl extends AbstractSimpleEntity implements OutputBinding {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<OutputBinding> wGetEntityDescriptor() {
        return SemanticsEntityDescriptorEnum.OutputBinding;
    }

    public int wGetEntityOrd() {
        return SemanticsEntityDescriptorEnum.OutputBinding_ord;
    }

    public void accept(ISemanticsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private BindingSubject identifier;

    public BindingSubject getIdentifier() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.identifier, identifier);
    }

    public void setIdentifier(BindingSubject identifier) {
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
            return getIdentifier().wGetAdaptee(false);
            case 1 :
            return getExpression().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setIdentifier(value.wGetAdapter(SemanticsEntityDescriptorEnum.BindingSubject));
            break;
            case 1 :
            setExpression(value.wGetAdapter(SemanticsEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
