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
package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.DistinctTest;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.queries.model.Comparator;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class DistinctTestImpl extends AbstractSimpleEntity implements DistinctTest {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<DistinctTest> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.DistinctTest;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.DistinctTest_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
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
            return getComparator().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setComparator(value.wGetAdapter(QueriesEntityDescriptorEnum.Comparator));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
