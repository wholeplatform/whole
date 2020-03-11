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
public class ObjcSelectorExprAdapter extends AbstractEntityAdapter implements ObjcSelectorExpr {
    private static final long serialVersionUID = 1;

    public ObjcSelectorExprAdapter(IEntity implementor) {
        super(implementor);
    }

    public ObjcSelectorExprAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ObjcSelectorExpr> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.ObjcSelectorExpr;
    }

    public Token getPoundSelector() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.poundSelector).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setPoundSelector(Token poundSelector) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundSelector, poundSelector);
    }

    public Token getLeftParen() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.leftParen).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setLeftParen(Token leftParen) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.leftParen, leftParen);
    }

    public Token getKind() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.kind).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setKind(Token kind) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.kind, kind);
    }

    public Token getColon() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.colon).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setColon(Token colon) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.colon, colon);
    }

    public Expr getName() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.name).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr);
    }

    public void setName(Expr name) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.name, name);
    }

    public Token getRightParen() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.rightParen).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setRightParen(Token rightParen) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.rightParen, rightParen);
    }
}
