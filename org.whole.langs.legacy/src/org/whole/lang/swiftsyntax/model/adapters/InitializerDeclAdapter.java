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
package org.whole.lang.swiftsyntax.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.swiftsyntax.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class InitializerDeclAdapter extends AbstractEntityAdapter implements InitializerDecl {
    private static final long serialVersionUID = 1;

    public InitializerDeclAdapter(IEntity implementor) {
        super(implementor);
    }

    public InitializerDeclAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<InitializerDecl> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.InitializerDecl;
    }

    public AttributeList getAttributes() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.attributes).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.AttributeList);
    }

    public void setAttributes(AttributeList attributes) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.attributes, attributes);
    }

    public ModifierList getModifiers() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.modifiers).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ModifierList);
    }

    public void setModifiers(ModifierList modifiers) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.modifiers, modifiers);
    }

    public Token getInitKeyword() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.initKeyword).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setInitKeyword(Token initKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.initKeyword, initKeyword);
    }

    public Token getOptionalMark() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.optionalMark).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setOptionalMark(Token optionalMark) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.optionalMark, optionalMark);
    }

    public GenericParameterClause getGenericParameterClause() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.genericParameterClause).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericParameterClause);
    }

    public void setGenericParameterClause(GenericParameterClause genericParameterClause) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.genericParameterClause, genericParameterClause);
    }

    public ParameterClause getParameters() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.parameters).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ParameterClause);
    }

    public void setParameters(ParameterClause parameters) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.parameters, parameters);
    }

    public Token getThrowsOrRethrowsKeyword() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.throwsOrRethrowsKeyword).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setThrowsOrRethrowsKeyword(Token throwsOrRethrowsKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.throwsOrRethrowsKeyword, throwsOrRethrowsKeyword);
    }

    public GenericWhereClause getGenericWhereClause() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericWhereClause);
    }

    public void setGenericWhereClause(GenericWhereClause genericWhereClause) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public CodeBlock getBody() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.body).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlock);
    }

    public void setBody(CodeBlock body) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.body, body);
    }
}
