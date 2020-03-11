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
import org.whole.lang.swift.model.TypealiasDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.AttributeList;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.ModifierList;
import org.whole.lang.swift.model.Identifier;
import org.whole.lang.swift.model.GenericParameterList;
import org.whole.lang.swift.model.Type;
import org.whole.lang.swift.model.GenericRequirementList;

/**
 *  @generator Whole
 */
public class TypealiasDeclImpl extends AbstractSimpleEntity implements TypealiasDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TypealiasDecl> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.TypealiasDecl;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.TypealiasDecl_ord;
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
    private ModifierList modifiers;

    public ModifierList getModifiers() {
        return notifyRequested(SwiftFeatureDescriptorEnum.modifiers, modifiers);
    }

    public void setModifiers(ModifierList modifiers) {
        notifyChanged(SwiftFeatureDescriptorEnum.modifiers, this.modifiers, this.modifiers = modifiers);
    }
    private Identifier identifier;

    public Identifier getIdentifier() {
        return notifyRequested(SwiftFeatureDescriptorEnum.identifier, identifier);
    }

    public void setIdentifier(Identifier identifier) {
        notifyChanged(SwiftFeatureDescriptorEnum.identifier, this.identifier, this.identifier = identifier);
    }
    private GenericParameterList genericParameterClause;

    public GenericParameterList getGenericParameterClause() {
        return notifyRequested(SwiftFeatureDescriptorEnum.genericParameterClause, genericParameterClause);
    }

    public void setGenericParameterClause(GenericParameterList genericParameterClause) {
        notifyChanged(SwiftFeatureDescriptorEnum.genericParameterClause, this.genericParameterClause, this.genericParameterClause = genericParameterClause);
    }
    private Type initializer;

    public Type getInitializer() {
        return notifyRequested(SwiftFeatureDescriptorEnum.initializer, initializer);
    }

    public void setInitializer(Type initializer) {
        notifyChanged(SwiftFeatureDescriptorEnum.initializer, this.initializer, this.initializer = initializer);
    }
    private GenericRequirementList genericWhereClause;

    public GenericRequirementList getGenericWhereClause() {
        return notifyRequested(SwiftFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public void setGenericWhereClause(GenericRequirementList genericWhereClause) {
        notifyChanged(SwiftFeatureDescriptorEnum.genericWhereClause, this.genericWhereClause, this.genericWhereClause = genericWhereClause);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getIdentifier().wGetAdaptee(false);
            case 3 :
            return getGenericParameterClause().wGetAdaptee(false);
            case 4 :
            return getInitializer().wGetAdaptee(false);
            case 5 :
            return getGenericWhereClause().wGetAdaptee(false);
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
            setModifiers(value.wGetAdapter(SwiftEntityDescriptorEnum.ModifierList));
            break;
            case 2 :
            setIdentifier(value.wGetAdapter(SwiftEntityDescriptorEnum.Identifier));
            break;
            case 3 :
            setGenericParameterClause(value.wGetAdapter(SwiftEntityDescriptorEnum.GenericParameterList));
            break;
            case 4 :
            setInitializer(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            case 5 :
            setGenericWhereClause(value.wGetAdapter(SwiftEntityDescriptorEnum.GenericRequirementList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 6;
    }
}
