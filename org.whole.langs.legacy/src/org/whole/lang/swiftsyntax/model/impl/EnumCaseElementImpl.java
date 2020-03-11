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
import org.whole.lang.swiftsyntax.model.EnumCaseElement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.ParameterClause;
import org.whole.lang.swiftsyntax.model.InitializerClause;

/**
 *  @generator Whole
 */
public class EnumCaseElementImpl extends AbstractSimpleEntity implements EnumCaseElement {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<EnumCaseElement> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.EnumCaseElement;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.EnumCaseElement_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token identifier;

    public Token getIdentifier() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.identifier, identifier);
    }

    public void setIdentifier(Token identifier) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.identifier, this.identifier, this.identifier = identifier);
    }
    private ParameterClause associatedValue;

    public ParameterClause getAssociatedValue() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.associatedValue, associatedValue);
    }

    public void setAssociatedValue(ParameterClause associatedValue) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.associatedValue, this.associatedValue, this.associatedValue = associatedValue);
    }
    private InitializerClause rawValue;

    public InitializerClause getRawValue() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.rawValue, rawValue);
    }

    public void setRawValue(InitializerClause rawValue) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.rawValue, this.rawValue, this.rawValue = rawValue);
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
            return getIdentifier().wGetAdaptee(false);
            case 1 :
            return getAssociatedValue().wGetAdaptee(false);
            case 2 :
            return getRawValue().wGetAdaptee(false);
            case 3 :
            return getTrailingComma().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setIdentifier(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setAssociatedValue(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ParameterClause));
            break;
            case 2 :
            setRawValue(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.InitializerClause));
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
