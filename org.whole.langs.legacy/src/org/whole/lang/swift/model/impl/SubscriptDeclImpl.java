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
import org.whole.lang.swift.model.SubscriptDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.AttributeList;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.ModifierList;
import org.whole.lang.swift.model.GenericParameterList;
import org.whole.lang.swift.model.FunctionParameterList;
import org.whole.lang.swift.model.Type;
import org.whole.lang.swift.model.GenericRequirementList;
import org.whole.lang.swift.model.AbstractAccessor;

/**
 *  @generator Whole
 */
public class SubscriptDeclImpl extends AbstractSimpleEntity implements SubscriptDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SubscriptDecl> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.SubscriptDecl;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.SubscriptDecl_ord;
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
    private GenericParameterList genericParameterClause;

    public GenericParameterList getGenericParameterClause() {
        return notifyRequested(SwiftFeatureDescriptorEnum.genericParameterClause, genericParameterClause);
    }

    public void setGenericParameterClause(GenericParameterList genericParameterClause) {
        notifyChanged(SwiftFeatureDescriptorEnum.genericParameterClause, this.genericParameterClause, this.genericParameterClause = genericParameterClause);
    }
    private FunctionParameterList indices;

    public FunctionParameterList getIndices() {
        return notifyRequested(SwiftFeatureDescriptorEnum.indices, indices);
    }

    public void setIndices(FunctionParameterList indices) {
        notifyChanged(SwiftFeatureDescriptorEnum.indices, this.indices, this.indices = indices);
    }
    private Type result;

    public Type getResult() {
        return notifyRequested(SwiftFeatureDescriptorEnum.result, result);
    }

    public void setResult(Type result) {
        notifyChanged(SwiftFeatureDescriptorEnum.result, this.result, this.result = result);
    }
    private GenericRequirementList genericWhereClause;

    public GenericRequirementList getGenericWhereClause() {
        return notifyRequested(SwiftFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public void setGenericWhereClause(GenericRequirementList genericWhereClause) {
        notifyChanged(SwiftFeatureDescriptorEnum.genericWhereClause, this.genericWhereClause, this.genericWhereClause = genericWhereClause);
    }
    private AbstractAccessor accessor;

    public AbstractAccessor getAccessor() {
        return notifyRequested(SwiftFeatureDescriptorEnum.accessor, accessor);
    }

    public void setAccessor(AbstractAccessor accessor) {
        notifyChanged(SwiftFeatureDescriptorEnum.accessor, this.accessor, this.accessor = accessor);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getGenericParameterClause().wGetAdaptee(false);
            case 3 :
            return getIndices().wGetAdaptee(false);
            case 4 :
            return getResult().wGetAdaptee(false);
            case 5 :
            return getGenericWhereClause().wGetAdaptee(false);
            case 6 :
            return getAccessor().wGetAdaptee(false);
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
            setGenericParameterClause(value.wGetAdapter(SwiftEntityDescriptorEnum.GenericParameterList));
            break;
            case 3 :
            setIndices(value.wGetAdapter(SwiftEntityDescriptorEnum.FunctionParameterList));
            break;
            case 4 :
            setResult(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            case 5 :
            setGenericWhereClause(value.wGetAdapter(SwiftEntityDescriptorEnum.GenericRequirementList));
            break;
            case 6 :
            setAccessor(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractAccessor));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 7;
    }
}
