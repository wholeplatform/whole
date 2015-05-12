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
package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.Intersect;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.queries.model.Expressions;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.model.Comparator;

/**
 *  @generator Whole
 */
public class IntersectImpl extends AbstractSimpleEntity implements Intersect {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Intersect> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Intersect;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.Intersect_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expressions expressions;

    public Expressions getExpressions() {
        return notifyRequested(QueriesFeatureDescriptorEnum.expressions, expressions);
    }

    public void setExpressions(Expressions expressions) {
        notifyChanged(QueriesFeatureDescriptorEnum.expressions, this.expressions, this.expressions = expressions);
    }
    private Comparator comparator;

    public Comparator getComparator() {
        return notifyRequested(QueriesFeatureDescriptorEnum.comparator, comparator);
    }

    public void setComparator(Comparator comparator) {
        notifyChanged(QueriesFeatureDescriptorEnum.comparator, this.comparator, this.comparator = comparator);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getExpressions().wGetAdaptee(false);
            case 1 :
            return getComparator().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setExpressions(value.wGetAdapter(QueriesEntityDescriptorEnum.Expressions));
            break;
            case 1 :
            setComparator(value.wGetAdapter(QueriesEntityDescriptorEnum.Comparator));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
