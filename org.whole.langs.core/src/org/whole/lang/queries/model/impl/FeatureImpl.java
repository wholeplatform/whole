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
import org.whole.lang.queries.model.Feature;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.queries.model.Name;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.model.Expression;

/**
 *  @generator Whole
 */
public class FeatureImpl extends AbstractSimpleEntity implements Feature {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Feature> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Feature;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.Feature_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name name;

    public Name getName() {
        return notifyRequested(QueriesFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(QueriesFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Expression value;

    public Expression getValue() {
        return notifyRequested(QueriesFeatureDescriptorEnum.value, value);
    }

    public void setValue(Expression value) {
        notifyChanged(QueriesFeatureDescriptorEnum.value, this.value, this.value = value);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getValue().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(QueriesEntityDescriptorEnum.Name));
            break;
            case 1 :
            setValue(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
