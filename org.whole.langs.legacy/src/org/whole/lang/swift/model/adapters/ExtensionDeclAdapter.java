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
package org.whole.lang.swift.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.swift.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ExtensionDeclAdapter extends AbstractEntityAdapter implements ExtensionDecl {
    private static final long serialVersionUID = 1;

    public ExtensionDeclAdapter(IEntity implementor) {
        super(implementor);
    }

    public ExtensionDeclAdapter() {
    }

    public void accept(ISwiftVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ExtensionDecl> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.ExtensionDecl;
    }

    public AttributeList getAttributes() {
        return wGet(SwiftFeatureDescriptorEnum.attributes).wGetAdapter(SwiftEntityDescriptorEnum.AttributeList);
    }

    public void setAttributes(AttributeList attributes) {
        wSet(SwiftFeatureDescriptorEnum.attributes, attributes);
    }

    public ModifierList getModifiers() {
        return wGet(SwiftFeatureDescriptorEnum.modifiers).wGetAdapter(SwiftEntityDescriptorEnum.ModifierList);
    }

    public void setModifiers(ModifierList modifiers) {
        wSet(SwiftFeatureDescriptorEnum.modifiers, modifiers);
    }

    public Type getExtendedType() {
        return wGet(SwiftFeatureDescriptorEnum.extendedType).wGetAdapter(SwiftEntityDescriptorEnum.Type);
    }

    public void setExtendedType(Type extendedType) {
        wSet(SwiftFeatureDescriptorEnum.extendedType, extendedType);
    }

    public InheritedTypeList getInheritanceClause() {
        return wGet(SwiftFeatureDescriptorEnum.inheritanceClause).wGetAdapter(SwiftEntityDescriptorEnum.InheritedTypeList);
    }

    public void setInheritanceClause(InheritedTypeList inheritanceClause) {
        wSet(SwiftFeatureDescriptorEnum.inheritanceClause, inheritanceClause);
    }

    public GenericRequirementList getGenericWhereClause() {
        return wGet(SwiftFeatureDescriptorEnum.genericWhereClause).wGetAdapter(SwiftEntityDescriptorEnum.GenericRequirementList);
    }

    public void setGenericWhereClause(GenericRequirementList genericWhereClause) {
        wSet(SwiftFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public MemberDeclList getMembers() {
        return wGet(SwiftFeatureDescriptorEnum.members).wGetAdapter(SwiftEntityDescriptorEnum.MemberDeclList);
    }

    public void setMembers(MemberDeclList members) {
        wSet(SwiftFeatureDescriptorEnum.members, members);
    }
}
