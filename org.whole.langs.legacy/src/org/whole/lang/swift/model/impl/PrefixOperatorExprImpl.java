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
import org.whole.lang.swift.model.PrefixOperatorExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.PrefixOperator;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.Expr;

/**
 *  @generator Whole
 */
public class PrefixOperatorExprImpl extends AbstractSimpleEntity implements PrefixOperatorExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PrefixOperatorExpr> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.PrefixOperatorExpr;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.PrefixOperatorExpr_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private PrefixOperator operatorToken;

    public PrefixOperator getOperatorToken() {
        return notifyRequested(SwiftFeatureDescriptorEnum.operatorToken, operatorToken);
    }

    public void setOperatorToken(PrefixOperator operatorToken) {
        notifyChanged(SwiftFeatureDescriptorEnum.operatorToken, this.operatorToken, this.operatorToken = operatorToken);
    }
    private Expr postfixExpression;

    public Expr getPostfixExpression() {
        return notifyRequested(SwiftFeatureDescriptorEnum.postfixExpression, postfixExpression);
    }

    public void setPostfixExpression(Expr postfixExpression) {
        notifyChanged(SwiftFeatureDescriptorEnum.postfixExpression, this.postfixExpression, this.postfixExpression = postfixExpression);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getOperatorToken().wGetAdaptee(false);
            case 1 :
            return getPostfixExpression().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setOperatorToken(value.wGetAdapter(SwiftEntityDescriptorEnum.PrefixOperator));
            break;
            case 1 :
            setPostfixExpression(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
