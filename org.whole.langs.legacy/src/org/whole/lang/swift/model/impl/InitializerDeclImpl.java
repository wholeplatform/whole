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
import org.whole.lang.swift.model.InitializerDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.AttributeList;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.ModifierList;
import org.whole.lang.swift.model.OptionalMarkEnum;
import org.whole.lang.swift.model.GenericParameterList;
import org.whole.lang.swift.model.FunctionParameterList;
import org.whole.lang.swift.model.ThrowsOrRethrowsKeywordEnum;
import org.whole.lang.swift.model.GenericRequirementList;
import org.whole.lang.swift.model.CodeBlockItemList;

/**
 *  @generator Whole
 */
public class InitializerDeclImpl extends AbstractSimpleEntity implements InitializerDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<InitializerDecl> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.InitializerDecl;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.InitializerDecl_ord;
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
    private OptionalMarkEnum optionalMark;

    public OptionalMarkEnum getOptionalMark() {
        return notifyRequested(SwiftFeatureDescriptorEnum.optionalMark, optionalMark);
    }

    public void setOptionalMark(OptionalMarkEnum optionalMark) {
        notifyChanged(SwiftFeatureDescriptorEnum.optionalMark, this.optionalMark, this.optionalMark = optionalMark);
    }
    private GenericParameterList genericParameterClause;

    public GenericParameterList getGenericParameterClause() {
        return notifyRequested(SwiftFeatureDescriptorEnum.genericParameterClause, genericParameterClause);
    }

    public void setGenericParameterClause(GenericParameterList genericParameterClause) {
        notifyChanged(SwiftFeatureDescriptorEnum.genericParameterClause, this.genericParameterClause, this.genericParameterClause = genericParameterClause);
    }
    private FunctionParameterList parameters;

    public FunctionParameterList getParameters() {
        return notifyRequested(SwiftFeatureDescriptorEnum.parameters, parameters);
    }

    public void setParameters(FunctionParameterList parameters) {
        notifyChanged(SwiftFeatureDescriptorEnum.parameters, this.parameters, this.parameters = parameters);
    }
    private ThrowsOrRethrowsKeywordEnum throwsOrRethrowsKeyword;

    public ThrowsOrRethrowsKeywordEnum getThrowsOrRethrowsKeyword() {
        return notifyRequested(SwiftFeatureDescriptorEnum.throwsOrRethrowsKeyword, throwsOrRethrowsKeyword);
    }

    public void setThrowsOrRethrowsKeyword(ThrowsOrRethrowsKeywordEnum throwsOrRethrowsKeyword) {
        notifyChanged(SwiftFeatureDescriptorEnum.throwsOrRethrowsKeyword, this.throwsOrRethrowsKeyword, this.throwsOrRethrowsKeyword = throwsOrRethrowsKeyword);
    }
    private GenericRequirementList genericWhereClause;

    public GenericRequirementList getGenericWhereClause() {
        return notifyRequested(SwiftFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public void setGenericWhereClause(GenericRequirementList genericWhereClause) {
        notifyChanged(SwiftFeatureDescriptorEnum.genericWhereClause, this.genericWhereClause, this.genericWhereClause = genericWhereClause);
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
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getOptionalMark().wGetAdaptee(false);
            case 3 :
            return getGenericParameterClause().wGetAdaptee(false);
            case 4 :
            return getParameters().wGetAdaptee(false);
            case 5 :
            return getThrowsOrRethrowsKeyword().wGetAdaptee(false);
            case 6 :
            return getGenericWhereClause().wGetAdaptee(false);
            case 7 :
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
            setModifiers(value.wGetAdapter(SwiftEntityDescriptorEnum.ModifierList));
            break;
            case 2 :
            setOptionalMark(value.wGetAdapter(SwiftEntityDescriptorEnum.OptionalMarkEnum));
            break;
            case 3 :
            setGenericParameterClause(value.wGetAdapter(SwiftEntityDescriptorEnum.GenericParameterList));
            break;
            case 4 :
            setParameters(value.wGetAdapter(SwiftEntityDescriptorEnum.FunctionParameterList));
            break;
            case 5 :
            setThrowsOrRethrowsKeyword(value.wGetAdapter(SwiftEntityDescriptorEnum.ThrowsOrRethrowsKeywordEnum));
            break;
            case 6 :
            setGenericWhereClause(value.wGetAdapter(SwiftEntityDescriptorEnum.GenericRequirementList));
            break;
            case 7 :
            setBody(value.wGetAdapter(SwiftEntityDescriptorEnum.CodeBlockItemList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 8;
    }
}
