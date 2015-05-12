/**
 *  Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.math.model.Quotient;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.math.model.Expression;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class QuotientImpl extends AbstractSimpleEntity implements Quotient {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Quotient> wGetEntityDescriptor() {
        return MathEntityDescriptorEnum.Quotient;
    }

    public int wGetEntityOrd() {
        return MathEntityDescriptorEnum.Quotient_ord;
    }

    public void accept(IMathVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression dividend;

    public Expression getDividend() {
        return notifyRequested(MathFeatureDescriptorEnum.dividend, dividend);
    }

    public void setDividend(Expression dividend) {
        notifyChanged(MathFeatureDescriptorEnum.dividend, this.dividend, this.dividend = dividend);
    }
    private Expression divisor;

    public Expression getDivisor() {
        return notifyRequested(MathFeatureDescriptorEnum.divisor, divisor);
    }

    public void setDivisor(Expression divisor) {
        notifyChanged(MathFeatureDescriptorEnum.divisor, this.divisor, this.divisor = divisor);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getDividend().wGetAdaptee(false);
            case 1 :
            return getDivisor().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setDividend(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setDivisor(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
