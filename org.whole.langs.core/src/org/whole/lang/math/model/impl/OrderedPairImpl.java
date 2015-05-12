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
import org.whole.lang.math.model.OrderedPair;
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
public class OrderedPairImpl extends AbstractSimpleEntity implements OrderedPair {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<OrderedPair> wGetEntityDescriptor() {
        return MathEntityDescriptorEnum.OrderedPair;
    }

    public int wGetEntityOrd() {
        return MathEntityDescriptorEnum.OrderedPair_ord;
    }

    public void accept(IMathVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression first;

    public Expression getFirst() {
        return notifyRequested(MathFeatureDescriptorEnum.first, first);
    }

    public void setFirst(Expression first) {
        notifyChanged(MathFeatureDescriptorEnum.first, this.first, this.first = first);
    }
    private Expression second;

    public Expression getSecond() {
        return notifyRequested(MathFeatureDescriptorEnum.second, second);
    }

    public void setSecond(Expression second) {
        notifyChanged(MathFeatureDescriptorEnum.second, this.second, this.second = second);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getFirst().wGetAdaptee(false);
            case 1 :
            return getSecond().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setFirst(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setSecond(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
