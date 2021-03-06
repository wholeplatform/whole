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
package org.whole.lang.swift.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.swift.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;

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

    public void accept(ISwiftVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<SubscriptExpr> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.SubscriptExpr;
    }

    public Expr getCalledExpression() {
        return wGet(SwiftFeatureDescriptorEnum.calledExpression).wGetAdapter(SwiftEntityDescriptorEnum.Expr);
    }

    public void setCalledExpression(Expr calledExpression) {
        wSet(SwiftFeatureDescriptorEnum.calledExpression, calledExpression);
    }

    public FunctionCallArgumentList getArgumentList() {
        return wGet(SwiftFeatureDescriptorEnum.argumentList).wGetAdapter(SwiftEntityDescriptorEnum.FunctionCallArgumentList);
    }

    public void setArgumentList(FunctionCallArgumentList argumentList) {
        wSet(SwiftFeatureDescriptorEnum.argumentList, argumentList);
    }

    public ClosureExpr getTrailingClosure() {
        return wGet(SwiftFeatureDescriptorEnum.trailingClosure).wGetAdapter(SwiftEntityDescriptorEnum.ClosureExpr);
    }

    public void setTrailingClosure(ClosureExpr trailingClosure) {
        wSet(SwiftFeatureDescriptorEnum.trailingClosure, trailingClosure);
    }
}
