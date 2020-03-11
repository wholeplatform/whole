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
import org.whole.lang.swiftsyntax.model.FunctionCallExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Expr;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.FunctionCallArgumentList;
import org.whole.lang.swiftsyntax.model.ClosureExpr;

/**
 *  @generator Whole
 */
public class FunctionCallExprImpl extends AbstractSimpleEntity implements FunctionCallExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<FunctionCallExpr> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.FunctionCallExpr;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.FunctionCallExpr_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expr calledExpression;

    public Expr getCalledExpression() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.calledExpression, calledExpression);
    }

    public void setCalledExpression(Expr calledExpression) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.calledExpression, this.calledExpression, this.calledExpression = calledExpression);
    }
    private Token leftParen;

    public Token getLeftParen() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leftParen, leftParen);
    }

    public void setLeftParen(Token leftParen) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leftParen, this.leftParen, this.leftParen = leftParen);
    }
    private FunctionCallArgumentList argumentList;

    public FunctionCallArgumentList getArgumentList() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.argumentList, argumentList);
    }

    public void setArgumentList(FunctionCallArgumentList argumentList) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.argumentList, this.argumentList, this.argumentList = argumentList);
    }
    private Token rightParen;

    public Token getRightParen() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.rightParen, rightParen);
    }

    public void setRightParen(Token rightParen) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.rightParen, this.rightParen, this.rightParen = rightParen);
    }
    private ClosureExpr trailingClosure;

    public ClosureExpr getTrailingClosure() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.trailingClosure, trailingClosure);
    }

    public void setTrailingClosure(ClosureExpr trailingClosure) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.trailingClosure, this.trailingClosure, this.trailingClosure = trailingClosure);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getCalledExpression().wGetAdaptee(false);
            case 1 :
            return getLeftParen().wGetAdaptee(false);
            case 2 :
            return getArgumentList().wGetAdaptee(false);
            case 3 :
            return getRightParen().wGetAdaptee(false);
            case 4 :
            return getTrailingClosure().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setCalledExpression(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr));
            break;
            case 1 :
            setLeftParen(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setArgumentList(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList));
            break;
            case 3 :
            setRightParen(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setTrailingClosure(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ClosureExpr));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
