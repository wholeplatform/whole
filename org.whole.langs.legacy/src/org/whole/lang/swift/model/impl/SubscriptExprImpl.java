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
import org.whole.lang.swift.model.SubscriptExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Expr;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.FunctionCallArgumentList;
import org.whole.lang.swift.model.ClosureExpr;

/**
 *  @generator Whole
 */
public class SubscriptExprImpl extends AbstractSimpleEntity implements SubscriptExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SubscriptExpr> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.SubscriptExpr;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.SubscriptExpr_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expr calledExpression;

    public Expr getCalledExpression() {
        return notifyRequested(SwiftFeatureDescriptorEnum.calledExpression, calledExpression);
    }

    public void setCalledExpression(Expr calledExpression) {
        notifyChanged(SwiftFeatureDescriptorEnum.calledExpression, this.calledExpression, this.calledExpression = calledExpression);
    }
    private FunctionCallArgumentList argumentList;

    public FunctionCallArgumentList getArgumentList() {
        return notifyRequested(SwiftFeatureDescriptorEnum.argumentList, argumentList);
    }

    public void setArgumentList(FunctionCallArgumentList argumentList) {
        notifyChanged(SwiftFeatureDescriptorEnum.argumentList, this.argumentList, this.argumentList = argumentList);
    }
    private ClosureExpr trailingClosure;

    public ClosureExpr getTrailingClosure() {
        return notifyRequested(SwiftFeatureDescriptorEnum.trailingClosure, trailingClosure);
    }

    public void setTrailingClosure(ClosureExpr trailingClosure) {
        notifyChanged(SwiftFeatureDescriptorEnum.trailingClosure, this.trailingClosure, this.trailingClosure = trailingClosure);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getCalledExpression().wGetAdaptee(false);
            case 1 :
            return getArgumentList().wGetAdaptee(false);
            case 2 :
            return getTrailingClosure().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setCalledExpression(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            case 1 :
            setArgumentList(value.wGetAdapter(SwiftEntityDescriptorEnum.FunctionCallArgumentList));
            break;
            case 2 :
            setTrailingClosure(value.wGetAdapter(SwiftEntityDescriptorEnum.ClosureExpr));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
