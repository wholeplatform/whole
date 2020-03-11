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
public class FunctionParameterAdapter extends AbstractEntityAdapter implements FunctionParameter {
    private static final long serialVersionUID = 1;

    public FunctionParameterAdapter(IEntity implementor) {
        super(implementor);
    }

    public FunctionParameterAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<FunctionParameter> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.FunctionParameter;
    }

    public AttributeList getAttributes() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.attributes).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.AttributeList);
    }

    public void setAttributes(AttributeList attributes) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.attributes, attributes);
    }

    public Token getFirstName() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.firstName).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setFirstName(Token firstName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.firstName, firstName);
    }

    public Token getSecondName() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.secondName).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setSecondName(Token secondName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.secondName, secondName);
    }

    public Token getColon() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.colon).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setColon(Token colon) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.colon, colon);
    }

    public Type getType() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.type).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type);
    }

    public void setType(Type type) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.type, type);
    }

    public Token getEllipsis() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.ellipsis).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setEllipsis(Token ellipsis) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.ellipsis, ellipsis);
    }

    public InitializerClause getDefaultArgument() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.defaultArgument).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.InitializerClause);
    }

    public void setDefaultArgument(InitializerClause defaultArgument) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.defaultArgument, defaultArgument);
    }

    public Token getTrailingComma() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.trailingComma).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setTrailingComma(Token trailingComma) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.trailingComma, trailingComma);
    }
}
