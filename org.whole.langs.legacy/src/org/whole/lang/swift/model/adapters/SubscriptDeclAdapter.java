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
public class SubscriptDeclAdapter extends AbstractEntityAdapter implements SubscriptDecl {
    private static final long serialVersionUID = 1;

    public SubscriptDeclAdapter(IEntity implementor) {
        super(implementor);
    }

    public SubscriptDeclAdapter() {
    }

    public void accept(ISwiftVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<SubscriptDecl> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.SubscriptDecl;
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

    public GenericParameterList getGenericParameterClause() {
        return wGet(SwiftFeatureDescriptorEnum.genericParameterClause).wGetAdapter(SwiftEntityDescriptorEnum.GenericParameterList);
    }

    public void setGenericParameterClause(GenericParameterList genericParameterClause) {
        wSet(SwiftFeatureDescriptorEnum.genericParameterClause, genericParameterClause);
    }

    public FunctionParameterList getIndices() {
        return wGet(SwiftFeatureDescriptorEnum.indices).wGetAdapter(SwiftEntityDescriptorEnum.FunctionParameterList);
    }

    public void setIndices(FunctionParameterList indices) {
        wSet(SwiftFeatureDescriptorEnum.indices, indices);
    }

    public Type getResult() {
        return wGet(SwiftFeatureDescriptorEnum.result).wGetAdapter(SwiftEntityDescriptorEnum.Type);
    }

    public void setResult(Type result) {
        wSet(SwiftFeatureDescriptorEnum.result, result);
    }

    public GenericRequirementList getGenericWhereClause() {
        return wGet(SwiftFeatureDescriptorEnum.genericWhereClause).wGetAdapter(SwiftEntityDescriptorEnum.GenericRequirementList);
    }

    public void setGenericWhereClause(GenericRequirementList genericWhereClause) {
        wSet(SwiftFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public AbstractAccessor getAccessor() {
        return wGet(SwiftFeatureDescriptorEnum.accessor).wGetAdapter(SwiftEntityDescriptorEnum.AbstractAccessor);
    }

    public void setAccessor(AbstractAccessor accessor) {
        wSet(SwiftFeatureDescriptorEnum.accessor, accessor);
    }
}
