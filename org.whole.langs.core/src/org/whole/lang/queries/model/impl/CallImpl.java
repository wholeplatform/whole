/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.queries.model.Call;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.model.Name;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.model.Expressions;

/**
 *  @generator Whole
 */
public class CallImpl extends AbstractSimpleEntity implements Call {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Call> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Call;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.Call_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(QueriesFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(QueriesFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Expressions arguments;

    public Expressions getArguments() {
        return notifyRequested(QueriesFeatureDescriptorEnum.arguments, arguments);
    }

    public void setArguments(Expressions arguments) {
        notifyChanged(QueriesFeatureDescriptorEnum.arguments, this.arguments, this.arguments = arguments);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getArguments().wGetAdaptee(false);
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
            setArguments(value.wGetAdapter(QueriesEntityDescriptorEnum.Expressions));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
