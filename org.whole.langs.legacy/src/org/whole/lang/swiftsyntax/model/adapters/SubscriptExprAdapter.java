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
public class SubscriptExprAdapter extends AbstractEntityAdapter implements SubscriptExpr {
    private static final long serialVersionUID = 1;

    public SubscriptExprAdapter(IEntity implementor) {
        super(implementor);
    }

    public SubscriptExprAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<SubscriptExpr> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.SubscriptExpr;
    }

    public Expr getCalledExpression() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.calledExpression).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr);
    }

    public void setCalledExpression(Expr calledExpression) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.calledExpression, calledExpression);
    }

    public Token getLeftBracket() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.leftBracket).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setLeftBracket(Token leftBracket) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.leftBracket, leftBracket);
    }

    public FunctionCallArgumentList getArgumentList() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.argumentList).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList);
    }

    public void setArgumentList(FunctionCallArgumentList argumentList) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.argumentList, argumentList);
    }

    public Token getRightBracket() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.rightBracket).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setRightBracket(Token rightBracket) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.rightBracket, rightBracket);
    }

    public ClosureExpr getTrailingClosure() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.trailingClosure).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ClosureExpr);
    }

    public void setTrailingClosure(ClosureExpr trailingClosure) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.trailingClosure, trailingClosure);
    }
}
