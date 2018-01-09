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
import org.whole.lang.queries.model.PointwiseUpdate;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.queries.model.Expression;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class PointwiseUpdateImpl extends AbstractSimpleEntity implements PointwiseUpdate {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PointwiseUpdate> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.PointwiseUpdate;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.PointwiseUpdate_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression fromClause;

    public Expression getFromClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.fromClause, fromClause);
    }

    public void setFromClause(Expression fromClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.fromClause, this.fromClause, this.fromClause = fromClause);
    }
    private Expression valuesClause;

    public Expression getValuesClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.valuesClause, valuesClause);
    }

    public void setValuesClause(Expression valuesClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.valuesClause, this.valuesClause, this.valuesClause = valuesClause);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getFromClause().wGetAdaptee(false);
            case 1 :
            return getValuesClause().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setFromClause(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setValuesClause(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
