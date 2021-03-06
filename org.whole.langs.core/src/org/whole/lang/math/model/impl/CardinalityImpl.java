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
import org.whole.lang.math.model.Cardinality;
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
public class CardinalityImpl extends AbstractSimpleEntity implements Cardinality {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Cardinality> wGetEntityDescriptor() {
        return MathEntityDescriptorEnum.Cardinality;
    }

    public int wGetEntityOrd() {
        return MathEntityDescriptorEnum.Cardinality_ord;
    }

    public void accept(IMathVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
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
            return getCollection().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setCollection(value.wGetAdapter(MathEntityDescriptorEnum.CollectionExpression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
