/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.math.model.Difference;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.math.model.CollectionExpression;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class DifferenceImpl extends AbstractSimpleEntity implements Difference {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Difference> wGetEntityDescriptor() {
        return MathEntityDescriptorEnum.Difference;
    }

    public int wGetEntityOrd() {
        return MathEntityDescriptorEnum.Difference_ord;
    }

    public void accept(IMathVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private CollectionExpression collection1;

    public CollectionExpression getCollection1() {
        return notifyRequested(MathFeatureDescriptorEnum.collection1, collection1);
    }

    public void setCollection1(CollectionExpression collection1) {
        notifyChanged(MathFeatureDescriptorEnum.collection1, this.collection1, this.collection1 = collection1);
    }
    private CollectionExpression collection2;

    public CollectionExpression getCollection2() {
        return notifyRequested(MathFeatureDescriptorEnum.collection2, collection2);
    }

    public void setCollection2(CollectionExpression collection2) {
        notifyChanged(MathFeatureDescriptorEnum.collection2, this.collection2, this.collection2 = collection2);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getCollection1().wGetAdaptee(false);
            case 1 :
            return getCollection2().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setCollection1(value.wGetAdapter(MathEntityDescriptorEnum.CollectionExpression));
            break;
            case 1 :
            setCollection2(value.wGetAdapter(MathEntityDescriptorEnum.CollectionExpression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
