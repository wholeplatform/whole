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
package org.whole.lang.swiftsyntax.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swiftsyntax.model.ArrayType;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Type;

/**
 *  @generator Whole
 */
public class ArrayTypeImpl extends AbstractSimpleEntity implements ArrayType {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ArrayType> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.ArrayType;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.ArrayType_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token leftSquareBracket;

    public Token getLeftSquareBracket() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leftSquareBracket, leftSquareBracket);
    }

    public void setLeftSquareBracket(Token leftSquareBracket) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leftSquareBracket, this.leftSquareBracket, this.leftSquareBracket = leftSquareBracket);
    }
    private Type elementType;

    public Type getElementType() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.elementType, elementType);
    }

    public void setElementType(Type elementType) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.elementType, this.elementType, this.elementType = elementType);
    }
    private Token rightSquareBracket;

    public Token getRightSquareBracket() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.rightSquareBracket, rightSquareBracket);
    }

    public void setRightSquareBracket(Token rightSquareBracket) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.rightSquareBracket, this.rightSquareBracket, this.rightSquareBracket = rightSquareBracket);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLeftSquareBracket().wGetAdaptee(false);
            case 1 :
            return getElementType().wGetAdaptee(false);
            case 2 :
            return getRightSquareBracket().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLeftSquareBracket(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setElementType(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type));
            break;
            case 2 :
            setRightSquareBracket(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
