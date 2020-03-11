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
import org.whole.lang.swiftsyntax.model.InitializerDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.AttributeList;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.ModifierList;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.GenericParameterClause;
import org.whole.lang.swiftsyntax.model.ParameterClause;
import org.whole.lang.swiftsyntax.model.GenericWhereClause;
import org.whole.lang.swiftsyntax.model.CodeBlock;

/**
 *  @generator Whole
 */
public class InitializerDeclImpl extends AbstractSimpleEntity implements InitializerDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<InitializerDecl> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.InitializerDecl;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.InitializerDecl_ord;
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
    private ModifierList modifiers;

    public ModifierList getModifiers() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.modifiers, modifiers);
    }

    public void setModifiers(ModifierList modifiers) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.modifiers, this.modifiers, this.modifiers = modifiers);
    }
    private Token initKeyword;

    public Token getInitKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.initKeyword, initKeyword);
    }

    public void setInitKeyword(Token initKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.initKeyword, this.initKeyword, this.initKeyword = initKeyword);
    }
    private Token optionalMark;

    public Token getOptionalMark() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.optionalMark, optionalMark);
    }

    public void setOptionalMark(Token optionalMark) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.optionalMark, this.optionalMark, this.optionalMark = optionalMark);
    }
    private GenericParameterClause genericParameterClause;

    public GenericParameterClause getGenericParameterClause() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.genericParameterClause, genericParameterClause);
    }

    public void setGenericParameterClause(GenericParameterClause genericParameterClause) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.genericParameterClause, this.genericParameterClause, this.genericParameterClause = genericParameterClause);
    }
    private ParameterClause parameters;

    public ParameterClause getParameters() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.parameters, parameters);
    }

    public void setParameters(ParameterClause parameters) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.parameters, this.parameters, this.parameters = parameters);
    }
    private Token throwsOrRethrowsKeyword;

    public Token getThrowsOrRethrowsKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.throwsOrRethrowsKeyword, throwsOrRethrowsKeyword);
    }

    public void setThrowsOrRethrowsKeyword(Token throwsOrRethrowsKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.throwsOrRethrowsKeyword, this.throwsOrRethrowsKeyword, this.throwsOrRethrowsKeyword = throwsOrRethrowsKeyword);
    }
    private GenericWhereClause genericWhereClause;

    public GenericWhereClause getGenericWhereClause() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public void setGenericWhereClause(GenericWhereClause genericWhereClause) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause, this.genericWhereClause, this.genericWhereClause = genericWhereClause);
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
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getInitKeyword().wGetAdaptee(false);
            case 3 :
            return getOptionalMark().wGetAdaptee(false);
            case 4 :
            return getGenericParameterClause().wGetAdaptee(false);
            case 5 :
            return getParameters().wGetAdaptee(false);
            case 6 :
            return getThrowsOrRethrowsKeyword().wGetAdaptee(false);
            case 7 :
            return getGenericWhereClause().wGetAdaptee(false);
            case 8 :
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
            setModifiers(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ModifierList));
            break;
            case 2 :
            setInitKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setOptionalMark(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setGenericParameterClause(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericParameterClause));
            break;
            case 5 :
            setParameters(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ParameterClause));
            break;
            case 6 :
            setThrowsOrRethrowsKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 7 :
            setGenericWhereClause(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericWhereClause));
            break;
            case 8 :
            setBody(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlock));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 9;
    }
}
