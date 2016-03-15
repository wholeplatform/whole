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
package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class OrderedPairAdapter extends AbstractEntityAdapter implements OrderedPair {
    private static final long serialVersionUID = 1;

    public OrderedPairAdapter(IEntity implementor) {
        super(implementor);
    }

    public OrderedPairAdapter() {
    }

    public void accept(IMathVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<OrderedPair> wGetEntityDescriptor() {
        return MathEntityDescriptorEnum.OrderedPair;
    }

    public Expression getFirst() {
        return wGet(MathFeatureDescriptorEnum.first).wGetAdapter(MathEntityDescriptorEnum.Expression);
    }

    public void setFirst(Expression first) {
        wSet(MathFeatureDescriptorEnum.first, first);
    }

    public Expression getSecond() {
        return wGet(MathFeatureDescriptorEnum.second).wGetAdapter(MathEntityDescriptorEnum.Expression);
    }

    public void setSecond(Expression second) {
        wSet(MathFeatureDescriptorEnum.second, second);
    }
}
