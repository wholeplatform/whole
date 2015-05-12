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
import org.whole.lang.math.model.Exponentiation;
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
public class ExponentiationImpl extends AbstractSimpleEntity implements Exponentiation {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Exponentiation> wGetEntityDescriptor() {
        return MathEntityDescriptorEnum.Exponentiation;
    }

    public int wGetEntityOrd() {
        return MathEntityDescriptorEnum.Exponentiation_ord;
    }

    public void accept(IMathVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression base;

    public Expression getBase() {
        return notifyRequested(MathFeatureDescriptorEnum.base, base);
    }

    public void setBase(Expression base) {
        notifyChanged(MathFeatureDescriptorEnum.base, this.base, this.base = base);
    }
    private Expression exponent;

    public Expression getExponent() {
        return notifyRequested(MathFeatureDescriptorEnum.exponent, exponent);
    }

    public void setExponent(Expression exponent) {
        notifyChanged(MathFeatureDescriptorEnum.exponent, this.exponent, this.exponent = exponent);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getBase().wGetAdaptee(false);
            case 1 :
            return getExponent().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setBase(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setExponent(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
