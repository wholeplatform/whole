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
import org.whole.lang.queries.model.Select;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.queries.model.Expression;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.model.NamesExpression;

/**
 *  @generator Whole
 */
public class SelectImpl extends AbstractSimpleEntity implements Select {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Select> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Select;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.Select_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression selectClause;

    public Expression getSelectClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.selectClause, selectClause);
    }

    public void setSelectClause(Expression selectClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.selectClause, this.selectClause, this.selectClause = selectClause);
    }
    private Expression fromClause;

    public Expression getFromClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.fromClause, fromClause);
    }

    public void setFromClause(Expression fromClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.fromClause, this.fromClause, this.fromClause = fromClause);
    }
    private Expression whereClause;

    public Expression getWhereClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.whereClause, whereClause);
    }

    public void setWhereClause(Expression whereClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.whereClause, this.whereClause, this.whereClause = whereClause);
    }
    private NamesExpression clearClause;

    public NamesExpression getClearClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.clearClause, clearClause);
    }

    public void setClearClause(NamesExpression clearClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.clearClause, this.clearClause, this.clearClause = clearClause);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSelectClause().wGetAdaptee(false);
            case 1 :
            return getFromClause().wGetAdaptee(false);
            case 2 :
            return getWhereClause().wGetAdaptee(false);
            case 3 :
            return getClearClause().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSelectClause(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setFromClause(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
            break;
            case 2 :
            setWhereClause(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
            break;
            case 3 :
            setClearClause(value.wGetAdapter(QueriesEntityDescriptorEnum.NamesExpression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
