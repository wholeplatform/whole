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
package org.whole.lang.json.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.json.model.Pair;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.json.model.Name;
import org.whole.lang.json.reflect.JSONFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.model.Value;

/**
 *  @generator Whole
 */
public class PairImpl extends AbstractSimpleEntity implements Pair {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Pair> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Pair;
    }

    public int wGetEntityOrd() {
        return JSONEntityDescriptorEnum.Pair_ord;
    }

    public void accept(IJSONVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name name;

    public Name getName() {
        return notifyRequested(JSONFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(JSONFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Value value;

    public Value getValue() {
        return notifyRequested(JSONFeatureDescriptorEnum.value, value);
    }

    public void setValue(Value value) {
        notifyChanged(JSONFeatureDescriptorEnum.value, this.value, this.value = value);
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
            setName(value.wGetAdapter(JSONEntityDescriptorEnum.Name));
            break;
            case 1 :
            setValue(value.wGetAdapter(JSONEntityDescriptorEnum.Value));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
