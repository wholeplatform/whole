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
import org.whole.lang.swift.model.TernaryExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Expr;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class TernaryExprImpl extends AbstractSimpleEntity implements TernaryExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TernaryExpr> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.TernaryExpr;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.TernaryExpr_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expr conditionExpression;

    public Expr getConditionExpression() {
        return notifyRequested(SwiftFeatureDescriptorEnum.conditionExpression, conditionExpression);
    }

    public void setConditionExpression(Expr conditionExpression) {
        notifyChanged(SwiftFeatureDescriptorEnum.conditionExpression, this.conditionExpression, this.conditionExpression = conditionExpression);
    }
    private Expr firstChoice;

    public Expr getFirstChoice() {
        return notifyRequested(SwiftFeatureDescriptorEnum.firstChoice, firstChoice);
    }

    public void setFirstChoice(Expr firstChoice) {
        notifyChanged(SwiftFeatureDescriptorEnum.firstChoice, this.firstChoice, this.firstChoice = firstChoice);
    }
    private Expr secondChoice;

    public Expr getSecondChoice() {
        return notifyRequested(SwiftFeatureDescriptorEnum.secondChoice, secondChoice);
    }

    public void setSecondChoice(Expr secondChoice) {
        notifyChanged(SwiftFeatureDescriptorEnum.secondChoice, this.secondChoice, this.secondChoice = secondChoice);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getConditionExpression().wGetAdaptee(false);
            case 1 :
            return getFirstChoice().wGetAdaptee(false);
            case 2 :
            return getSecondChoice().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setConditionExpression(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            case 1 :
            setFirstChoice(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            case 2 :
            setSecondChoice(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
