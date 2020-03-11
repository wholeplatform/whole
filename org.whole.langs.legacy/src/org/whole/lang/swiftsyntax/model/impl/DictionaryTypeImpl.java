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
import org.whole.lang.swiftsyntax.model.DictionaryType;
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
public class DictionaryTypeImpl extends AbstractSimpleEntity implements DictionaryType {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<DictionaryType> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.DictionaryType;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.DictionaryType_ord;
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
    private Type keyType;

    public Type getKeyType() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.keyType, keyType);
    }

    public void setKeyType(Type keyType) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.keyType, this.keyType, this.keyType = keyType);
    }
    private Token colon;

    public Token getColon() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.colon, colon);
    }

    public void setColon(Token colon) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.colon, this.colon, this.colon = colon);
    }
    private Type valueType;

    public Type getValueType() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.valueType, valueType);
    }

    public void setValueType(Type valueType) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.valueType, this.valueType, this.valueType = valueType);
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
            return getKeyType().wGetAdaptee(false);
            case 2 :
            return getColon().wGetAdaptee(false);
            case 3 :
            return getValueType().wGetAdaptee(false);
            case 4 :
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
            setKeyType(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type));
            break;
            case 2 :
            setColon(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setValueType(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type));
            break;
            case 4 :
            setRightSquareBracket(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
