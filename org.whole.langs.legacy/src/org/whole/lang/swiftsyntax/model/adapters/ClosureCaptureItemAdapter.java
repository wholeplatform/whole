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
public class ClosureCaptureItemAdapter extends AbstractEntityAdapter implements ClosureCaptureItem {
    private static final long serialVersionUID = 1;

    public ClosureCaptureItemAdapter(IEntity implementor) {
        super(implementor);
    }

    public ClosureCaptureItemAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ClosureCaptureItem> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem;
    }

    public TokenList getSpecifier() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.specifier).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TokenList);
    }

    public void setSpecifier(TokenList specifier) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.specifier, specifier);
    }

    public Token getName() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.name).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setName(Token name) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.name, name);
    }

    public Token getAssignToken() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.assignToken).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setAssignToken(Token assignToken) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.assignToken, assignToken);
    }

    public Expr getExpression() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.expression).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr);
    }

    public void setExpression(Expr expression) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.expression, expression);
    }

    public Token getTrailingComma() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.trailingComma).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setTrailingComma(Token trailingComma) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.trailingComma, trailingComma);
    }
}
