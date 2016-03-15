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
package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.VariableDeclarationExpression;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.ExtendedModifiers;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.Type;
import org.whole.lang.java.model.VariableDeclarationFragments;

/**
 *  @generator Whole
 */
public class VariableDeclarationExpressionImpl extends AbstractSimpleEntity implements VariableDeclarationExpression {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<VariableDeclarationExpression> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.VariableDeclarationExpression;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.VariableDeclarationExpression_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private ExtendedModifiers modifiers;

    public ExtendedModifiers getModifiers() {
        return notifyRequested(JavaFeatureDescriptorEnum.modifiers, modifiers);
    }

    public void setModifiers(ExtendedModifiers modifiers) {
        notifyChanged(JavaFeatureDescriptorEnum.modifiers, this.modifiers, this.modifiers = modifiers);
    }
    private Type type;

    public Type getType() {
        return notifyRequested(JavaFeatureDescriptorEnum.type, type);
    }

    public void setType(Type type) {
        notifyChanged(JavaFeatureDescriptorEnum.type, this.type, this.type = type);
    }
    private VariableDeclarationFragments fragments;

    public VariableDeclarationFragments getFragments() {
        return notifyRequested(JavaFeatureDescriptorEnum.fragments, fragments);
    }

    public void setFragments(VariableDeclarationFragments fragments) {
        notifyChanged(JavaFeatureDescriptorEnum.fragments, this.fragments, this.fragments = fragments);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getModifiers().wGetAdaptee(false);
            case 1 :
            return getType().wGetAdaptee(false);
            case 2 :
            return getFragments().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setModifiers(value.wGetAdapter(JavaEntityDescriptorEnum.ExtendedModifiers));
            break;
            case 1 :
            setType(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
            break;
            case 2 :
            setFragments(value.wGetAdapter(JavaEntityDescriptorEnum.VariableDeclarationFragments));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
