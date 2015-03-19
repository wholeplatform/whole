/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.math.model.Subtraction;
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
public class SubtractionImpl extends AbstractSimpleEntity implements Subtraction {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Subtraction> wGetEntityDescriptor() {
        return MathEntityDescriptorEnum.Subtraction;
    }

    public int wGetEntityOrd() {
        return MathEntityDescriptorEnum.Subtraction_ord;
    }

    public void accept(IMathVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression minuend;

    public Expression getMinuend() {
        return notifyRequested(MathFeatureDescriptorEnum.minuend, minuend);
    }

    public void setMinuend(Expression minuend) {
        notifyChanged(MathFeatureDescriptorEnum.minuend, this.minuend, this.minuend = minuend);
    }
    private Expression subtrahend;

    public Expression getSubtrahend() {
        return notifyRequested(MathFeatureDescriptorEnum.subtrahend, subtrahend);
    }

    public void setSubtrahend(Expression subtrahend) {
        notifyChanged(MathFeatureDescriptorEnum.subtrahend, this.subtrahend, this.subtrahend = subtrahend);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getMinuend().wGetAdaptee(false);
            case 1 :
            return getSubtrahend().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setMinuend(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setSubtrahend(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
