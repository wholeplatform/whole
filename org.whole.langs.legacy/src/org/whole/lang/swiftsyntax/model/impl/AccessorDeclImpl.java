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
import org.whole.lang.swiftsyntax.model.AccessorDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.AttributeList;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.DeclModifier;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.AccessorParameter;
import org.whole.lang.swiftsyntax.model.CodeBlock;

/**
 *  @generator Whole
 */
public class AccessorDeclImpl extends AbstractSimpleEntity implements AccessorDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<AccessorDecl> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.AccessorDecl;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.AccessorDecl_ord;
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
    private DeclModifier modifier;

    public DeclModifier getModifier() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.modifier, modifier);
    }

    public void setModifier(DeclModifier modifier) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.modifier, this.modifier, this.modifier = modifier);
    }
    private Token accessorKind;

    public Token getAccessorKind() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.accessorKind, accessorKind);
    }

    public void setAccessorKind(Token accessorKind) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.accessorKind, this.accessorKind, this.accessorKind = accessorKind);
    }
    private AccessorParameter parameter;

    public AccessorParameter getParameter() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.parameter, parameter);
    }

    public void setParameter(AccessorParameter parameter) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.parameter, this.parameter, this.parameter = parameter);
    }
    private CodeBlock body;

    public CodeBlock getBody() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.body, body);
    }

    public void setBody(CodeBlock body) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.body, this.body, this.body = body);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifier().wGetAdaptee(false);
            case 2 :
            return getAccessorKind().wGetAdaptee(false);
            case 3 :
            return getParameter().wGetAdaptee(false);
            case 4 :
            return getBody().wGetAdaptee(false);
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
            setModifier(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.DeclModifier));
            break;
            case 2 :
            setAccessorKind(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setParameter(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.AccessorParameter));
            break;
            case 4 :
            setBody(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlock));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
