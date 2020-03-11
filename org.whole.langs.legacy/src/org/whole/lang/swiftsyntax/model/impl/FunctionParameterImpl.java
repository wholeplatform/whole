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
import org.whole.lang.swiftsyntax.model.FunctionParameter;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.AttributeList;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.Type;
import org.whole.lang.swiftsyntax.model.InitializerClause;

/**
 *  @generator Whole
 */
public class FunctionParameterImpl extends AbstractSimpleEntity implements FunctionParameter {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<FunctionParameter> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.FunctionParameter;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.FunctionParameter_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private AttributeList attributes;

    public AttributeList getAttributes() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.attributes, attributes);
    }

    public void setAttributes(AttributeList attributes) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.attributes, this.attributes, this.attributes = attributes);
    }
    private Token firstName;

    public Token getFirstName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.firstName, firstName);
    }

    public void setFirstName(Token firstName) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.firstName, this.firstName, this.firstName = firstName);
    }
    private Token secondName;

    public Token getSecondName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.secondName, secondName);
    }

    public void setSecondName(Token secondName) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.secondName, this.secondName, this.secondName = secondName);
    }
    private Token colon;

    public Token getColon() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.colon, colon);
    }

    public void setColon(Token colon) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.colon, this.colon, this.colon = colon);
    }
    private Type type;

    public Type getType() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.type, type);
    }

    public void setType(Type type) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.type, this.type, this.type = type);
    }
    private Token ellipsis;

    public Token getEllipsis() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.ellipsis, ellipsis);
    }

    public void setEllipsis(Token ellipsis) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.ellipsis, this.ellipsis, this.ellipsis = ellipsis);
    }
    private InitializerClause defaultArgument;

    public InitializerClause getDefaultArgument() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.defaultArgument, defaultArgument);
    }

    public void setDefaultArgument(InitializerClause defaultArgument) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.defaultArgument, this.defaultArgument, this.defaultArgument = defaultArgument);
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
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getFirstName().wGetAdaptee(false);
            case 2 :
            return getSecondName().wGetAdaptee(false);
            case 3 :
            return getColon().wGetAdaptee(false);
            case 4 :
            return getType().wGetAdaptee(false);
            case 5 :
            return getEllipsis().wGetAdaptee(false);
            case 6 :
            return getDefaultArgument().wGetAdaptee(false);
            case 7 :
            return getTrailingComma().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setAttributes(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.AttributeList));
            break;
            case 1 :
            setFirstName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setSecondName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setColon(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setType(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type));
            break;
            case 5 :
            setEllipsis(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 6 :
            setDefaultArgument(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.InitializerClause));
            break;
            case 7 :
            setTrailingComma(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 8;
    }
}
