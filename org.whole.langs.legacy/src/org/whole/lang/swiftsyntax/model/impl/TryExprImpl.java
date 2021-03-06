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
import org.whole.lang.swiftsyntax.model.TryExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Expr;

/**
 *  @generator Whole
 */
public class TryExprImpl extends AbstractSimpleEntity implements TryExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TryExpr> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.TryExpr;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.TryExpr_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token tryKeyword;

    public Token getTryKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.tryKeyword, tryKeyword);
    }

    public void setTryKeyword(Token tryKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.tryKeyword, this.tryKeyword, this.tryKeyword = tryKeyword);
    }
    private Token questionOrExclamationMark;

    public Token getQuestionOrExclamationMark() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.questionOrExclamationMark, questionOrExclamationMark);
    }

    public void setQuestionOrExclamationMark(Token questionOrExclamationMark) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.questionOrExclamationMark, this.questionOrExclamationMark, this.questionOrExclamationMark = questionOrExclamationMark);
    }
    private Expr expression;

    public Expr getExpression() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(Expr expression) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getTryKeyword().wGetAdaptee(false);
            case 1 :
            return getQuestionOrExclamationMark().wGetAdaptee(false);
            case 2 :
            return getExpression().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setTryKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setQuestionOrExclamationMark(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setExpression(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
