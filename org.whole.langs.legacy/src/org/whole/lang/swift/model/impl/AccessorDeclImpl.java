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
package org.whole.lang.swift.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swift.model.AccessorDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.AttributeList;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.DeclModifier;
import org.whole.lang.swift.model.AccessorKindValue;
import org.whole.lang.swift.model.Identifier;
import org.whole.lang.swift.model.CodeBlockItemList;

/**
 *  @generator Whole
 */
public class AccessorDeclImpl extends AbstractSimpleEntity implements AccessorDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<AccessorDecl> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.AccessorDecl;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.AccessorDecl_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private AttributeList attributes;

    public AttributeList getAttributes() {
        return notifyRequested(SwiftFeatureDescriptorEnum.attributes, attributes);
    }

    public void setAttributes(AttributeList attributes) {
        notifyChanged(SwiftFeatureDescriptorEnum.attributes, this.attributes, this.attributes = attributes);
    }
    private DeclModifier modifier;

    public DeclModifier getModifier() {
        return notifyRequested(SwiftFeatureDescriptorEnum.modifier, modifier);
    }

    public void setModifier(DeclModifier modifier) {
        notifyChanged(SwiftFeatureDescriptorEnum.modifier, this.modifier, this.modifier = modifier);
    }
    private AccessorKindValue accessorKind;

    public AccessorKindValue getAccessorKind() {
        return notifyRequested(SwiftFeatureDescriptorEnum.accessorKind, accessorKind);
    }

    public void setAccessorKind(AccessorKindValue accessorKind) {
        notifyChanged(SwiftFeatureDescriptorEnum.accessorKind, this.accessorKind, this.accessorKind = accessorKind);
    }
    private Identifier parameter;

    public Identifier getParameter() {
        return notifyRequested(SwiftFeatureDescriptorEnum.parameter, parameter);
    }

    public void setParameter(Identifier parameter) {
        notifyChanged(SwiftFeatureDescriptorEnum.parameter, this.parameter, this.parameter = parameter);
    }
    private CodeBlockItemList body;

    public CodeBlockItemList getBody() {
        return notifyRequested(SwiftFeatureDescriptorEnum.body, body);
    }

    public void setBody(CodeBlockItemList body) {
        notifyChanged(SwiftFeatureDescriptorEnum.body, this.body, this.body = body);
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
            setAttributes(value.wGetAdapter(SwiftEntityDescriptorEnum.AttributeList));
            break;
            case 1 :
            setModifier(value.wGetAdapter(SwiftEntityDescriptorEnum.DeclModifier));
            break;
            case 2 :
            setAccessorKind(value.wGetAdapter(SwiftEntityDescriptorEnum.AccessorKindValue));
            break;
            case 3 :
            setParameter(value.wGetAdapter(SwiftEntityDescriptorEnum.Identifier));
            break;
            case 4 :
            setBody(value.wGetAdapter(SwiftEntityDescriptorEnum.CodeBlockItemList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
