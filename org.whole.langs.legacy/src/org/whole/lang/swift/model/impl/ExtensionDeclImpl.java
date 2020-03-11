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
import org.whole.lang.swift.model.ExtensionDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.AttributeList;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.ModifierList;
import org.whole.lang.swift.model.Type;
import org.whole.lang.swift.model.InheritedTypeList;
import org.whole.lang.swift.model.GenericRequirementList;
import org.whole.lang.swift.model.MemberDeclList;

/**
 *  @generator Whole
 */
public class ExtensionDeclImpl extends AbstractSimpleEntity implements ExtensionDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ExtensionDecl> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.ExtensionDecl;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.ExtensionDecl_ord;
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
    private Type extendedType;

    public Type getExtendedType() {
        return notifyRequested(SwiftFeatureDescriptorEnum.extendedType, extendedType);
    }

    public void setExtendedType(Type extendedType) {
        notifyChanged(SwiftFeatureDescriptorEnum.extendedType, this.extendedType, this.extendedType = extendedType);
    }
    private InheritedTypeList inheritanceClause;

    public InheritedTypeList getInheritanceClause() {
        return notifyRequested(SwiftFeatureDescriptorEnum.inheritanceClause, inheritanceClause);
    }

    public void setInheritanceClause(InheritedTypeList inheritanceClause) {
        notifyChanged(SwiftFeatureDescriptorEnum.inheritanceClause, this.inheritanceClause, this.inheritanceClause = inheritanceClause);
    }
    private GenericRequirementList genericWhereClause;

    public GenericRequirementList getGenericWhereClause() {
        return notifyRequested(SwiftFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public void setGenericWhereClause(GenericRequirementList genericWhereClause) {
        notifyChanged(SwiftFeatureDescriptorEnum.genericWhereClause, this.genericWhereClause, this.genericWhereClause = genericWhereClause);
    }
    private MemberDeclList members;

    public MemberDeclList getMembers() {
        return notifyRequested(SwiftFeatureDescriptorEnum.members, members);
    }

    public void setMembers(MemberDeclList members) {
        notifyChanged(SwiftFeatureDescriptorEnum.members, this.members, this.members = members);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getExtendedType().wGetAdaptee(false);
            case 3 :
            return getInheritanceClause().wGetAdaptee(false);
            case 4 :
            return getGenericWhereClause().wGetAdaptee(false);
            case 5 :
            return getMembers().wGetAdaptee(false);
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
            setExtendedType(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            case 3 :
            setInheritanceClause(value.wGetAdapter(SwiftEntityDescriptorEnum.InheritedTypeList));
            break;
            case 4 :
            setGenericWhereClause(value.wGetAdapter(SwiftEntityDescriptorEnum.GenericRequirementList));
            break;
            case 5 :
            setMembers(value.wGetAdapter(SwiftEntityDescriptorEnum.MemberDeclList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 6;
    }
}
