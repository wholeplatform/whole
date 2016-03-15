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
package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.PointwiseEquals;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class PointwiseEqualsImpl extends AbstractSimpleEntity implements PointwiseEquals {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PointwiseEquals> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.PointwiseEquals;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.PointwiseEquals_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private PathExpression pexp1;

    public PathExpression getPexp1() {
        return notifyRequested(QueriesFeatureDescriptorEnum.pexp1, pexp1);
    }

    public void setPexp1(PathExpression pexp1) {
        notifyChanged(QueriesFeatureDescriptorEnum.pexp1, this.pexp1, this.pexp1 = pexp1);
    }
    private PathExpression pexp2;

    public PathExpression getPexp2() {
        return notifyRequested(QueriesFeatureDescriptorEnum.pexp2, pexp2);
    }

    public void setPexp2(PathExpression pexp2) {
        notifyChanged(QueriesFeatureDescriptorEnum.pexp2, this.pexp2, this.pexp2 = pexp2);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getPexp1().wGetAdaptee(false);
            case 1 :
            return getPexp2().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setPexp1(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
            break;
            case 1 :
            setPexp2(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
