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
import org.whole.lang.swiftsyntax.model.ClosureCaptureItem;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.TokenList;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.Expr;

/**
 *  @generator Whole
 */
public class ClosureCaptureItemImpl extends AbstractSimpleEntity implements ClosureCaptureItem {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ClosureCaptureItem> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private TokenList specifier;

    public TokenList getSpecifier() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.specifier, specifier);
    }

    public void setSpecifier(TokenList specifier) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.specifier, this.specifier, this.specifier = specifier);
    }
    private Token name;

    public Token getName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.name, name);
    }

    public void setName(Token name) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Token assignToken;

    public Token getAssignToken() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.assignToken, assignToken);
    }

    public void setAssignToken(Token assignToken) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.assignToken, this.assignToken, this.assignToken = assignToken);
    }
    private Expr expression;

    public Expr getExpression() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(Expr expression) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }
    private Token trailingComma;

    public Token getTrailingComma() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.trailingComma, trailingComma);
    }

    public void setTrailingComma(Token trailingComma) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.trailingComma, this.trailingComma, this.trailingComma = trailingComma);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSpecifier().wGetAdaptee(false);
            case 1 :
            return getName().wGetAdaptee(false);
            case 2 :
            return getAssignToken().wGetAdaptee(false);
            case 3 :
            return getExpression().wGetAdaptee(false);
            case 4 :
            return getTrailingComma().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSpecifier(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TokenList));
            break;
            case 1 :
            setName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setAssignToken(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setExpression(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr));
            break;
            case 4 :
            setTrailingComma(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
