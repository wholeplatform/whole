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
import org.whole.lang.queries.model.CartesianInsert;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.queries.model.Placement;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.model.PathExpression;

/**
 *  @generator Whole
 */
public class CartesianInsertImpl extends AbstractSimpleEntity implements CartesianInsert {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<CartesianInsert> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.CartesianInsert;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.CartesianInsert_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Placement placement;

    public Placement getPlacement() {
        return notifyRequested(QueriesFeatureDescriptorEnum.placement, placement);
    }

    public void setPlacement(Placement placement) {
        notifyChanged(QueriesFeatureDescriptorEnum.placement, this.placement, this.placement = placement);
    }
    private PathExpression fromClause;

    public PathExpression getFromClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.fromClause, fromClause);
    }

    public void setFromClause(PathExpression fromClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.fromClause, this.fromClause, this.fromClause = fromClause);
    }
    private PathExpression valuesClause;

    public PathExpression getValuesClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.valuesClause, valuesClause);
    }

    public void setValuesClause(PathExpression valuesClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.valuesClause, this.valuesClause, this.valuesClause = valuesClause);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getPlacement().wGetAdaptee(false);
            case 1 :
            return getFromClause().wGetAdaptee(false);
            case 2 :
            return getValuesClause().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setPlacement(value.wGetAdapter(QueriesEntityDescriptorEnum.Placement));
            break;
            case 1 :
            setFromClause(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
            break;
            case 2 :
            setValuesClause(value.wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
