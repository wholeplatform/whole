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
import org.whole.lang.queries.model.Create;
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
public class CreateImpl extends AbstractSimpleEntity implements Create {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Create> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Create;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.Create_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression entityType;

    public Expression getEntityType() {
        return notifyRequested(QueriesFeatureDescriptorEnum.entityType, entityType);
    }

    public void setEntityType(Expression entityType) {
        notifyChanged(QueriesFeatureDescriptorEnum.entityType, this.entityType, this.entityType = entityType);
    }
    private Expression registry;

    public Expression getRegistry() {
        return notifyRequested(QueriesFeatureDescriptorEnum.registry, registry);
    }

    public void setRegistry(Expression registry) {
        notifyChanged(QueriesFeatureDescriptorEnum.registry, this.registry, this.registry = registry);
    }
    private Expression whereClause;

    public Expression getWhereClause() {
        return notifyRequested(QueriesFeatureDescriptorEnum.whereClause, whereClause);
    }

    public void setWhereClause(Expression whereClause) {
        notifyChanged(QueriesFeatureDescriptorEnum.whereClause, this.whereClause, this.whereClause = whereClause);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getEntityType().wGetAdaptee(false);
            case 1 :
            return getRegistry().wGetAdaptee(false);
            case 2 :
            return getWhereClause().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setEntityType(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setRegistry(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
            break;
            case 2 :
            setWhereClause(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
