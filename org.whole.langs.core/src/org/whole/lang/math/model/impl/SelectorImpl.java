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
package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.math.model.Selector;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.math.model.Expression;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.model.CollectionExpression;

/**
 *  @generator Whole
 */
public class SelectorImpl extends AbstractSimpleEntity implements Selector {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Selector> wGetEntityDescriptor() {
        return MathEntityDescriptorEnum.Selector;
    }

    public int wGetEntityOrd() {
        return MathEntityDescriptorEnum.Selector_ord;
    }

    public void accept(IMathVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression index;

    public Expression getIndex() {
        return notifyRequested(MathFeatureDescriptorEnum.index, index);
    }

    public void setIndex(Expression index) {
        notifyChanged(MathFeatureDescriptorEnum.index, this.index, this.index = index);
    }
    private CollectionExpression collection;

    public CollectionExpression getCollection() {
        return notifyRequested(MathFeatureDescriptorEnum.collection, collection);
    }

    public void setCollection(CollectionExpression collection) {
        notifyChanged(MathFeatureDescriptorEnum.collection, this.collection, this.collection = collection);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getIndex().wGetAdaptee(false);
            case 1 :
            return getCollection().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setIndex(value.wGetAdapter(MathEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setCollection(value.wGetAdapter(MathEntityDescriptorEnum.CollectionExpression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
