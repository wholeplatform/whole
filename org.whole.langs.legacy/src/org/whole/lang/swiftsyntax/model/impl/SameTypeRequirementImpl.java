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
import org.whole.lang.swiftsyntax.model.SameTypeRequirement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Type;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;

/**
 *  @generator Whole
 */
public class SameTypeRequirementImpl extends AbstractSimpleEntity implements SameTypeRequirement {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SameTypeRequirement> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.SameTypeRequirement;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.SameTypeRequirement_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Type leftTypeIdentifier;

    public Type getLeftTypeIdentifier() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leftTypeIdentifier, leftTypeIdentifier);
    }

    public void setLeftTypeIdentifier(Type leftTypeIdentifier) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leftTypeIdentifier, this.leftTypeIdentifier, this.leftTypeIdentifier = leftTypeIdentifier);
    }
    private Token equalityToken;

    public Token getEqualityToken() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.equalityToken, equalityToken);
    }

    public void setEqualityToken(Token equalityToken) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.equalityToken, this.equalityToken, this.equalityToken = equalityToken);
    }
    private Type rightTypeIdentifier;

    public Type getRightTypeIdentifier() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.rightTypeIdentifier, rightTypeIdentifier);
    }

    public void setRightTypeIdentifier(Type rightTypeIdentifier) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.rightTypeIdentifier, this.rightTypeIdentifier, this.rightTypeIdentifier = rightTypeIdentifier);
    }
    private Token trailingComma;

    public Token getTrailingComma() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.trailingComma, trailingComma);
    }

    public void setTrailingComma(Token trailingComma) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.trailingComma, this.trailingComma, this.trailingComma = trailingComma);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLeftTypeIdentifier().wGetAdaptee(false);
            case 1 :
            return getEqualityToken().wGetAdaptee(false);
            case 2 :
            return getRightTypeIdentifier().wGetAdaptee(false);
            case 3 :
            return getTrailingComma().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLeftTypeIdentifier(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type));
            break;
            case 1 :
            setEqualityToken(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setRightTypeIdentifier(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type));
            break;
            case 3 :
            setTrailingComma(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
