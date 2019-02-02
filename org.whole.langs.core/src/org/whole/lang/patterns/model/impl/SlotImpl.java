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
package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.Slot;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.patterns.model.Name;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.model.BooleanValue;
import org.whole.lang.patterns.model.Expression;
import org.whole.lang.patterns.model.Type;

/**
 *  @generator Whole
 */
public class SlotImpl extends AbstractSimpleEntity implements Slot {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Slot> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Slot;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.Slot_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name name;

    public Name getName() {
        return notifyRequested(PatternsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(PatternsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private BooleanValue optional;

    public BooleanValue getOptional() {
        return notifyRequested(PatternsFeatureDescriptorEnum.optional, optional);
    }

    public void setOptional(BooleanValue optional) {
        notifyChanged(PatternsFeatureDescriptorEnum.optional, this.optional, this.optional = optional);
    }
    private Expression adapter;

    public Expression getAdapter() {
        return notifyRequested(PatternsFeatureDescriptorEnum.adapter, adapter);
    }

    public void setAdapter(Expression adapter) {
        notifyChanged(PatternsFeatureDescriptorEnum.adapter, this.adapter, this.adapter = adapter);
    }
    private Type type;

    public Type getType() {
        return notifyRequested(PatternsFeatureDescriptorEnum.type, type);
    }

    public void setType(Type type) {
        notifyChanged(PatternsFeatureDescriptorEnum.type, this.type, this.type = type);
    }
    private Type resultType;

    public Type getResultType() {
        return notifyRequested(PatternsFeatureDescriptorEnum.resultType, resultType);
    }

    public void setResultType(Type resultType) {
        notifyChanged(PatternsFeatureDescriptorEnum.resultType, this.resultType, this.resultType = resultType);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getOptional().wGetAdaptee(false);
            case 2 :
            return getAdapter().wGetAdaptee(false);
            case 3 :
            return getType().wGetAdaptee(false);
            case 4 :
            return getResultType().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            case 1 :
            setOptional(value.wGetAdapter(PatternsEntityDescriptorEnum.BooleanValue));
            break;
            case 2 :
            setAdapter(value.wGetAdapter(PatternsEntityDescriptorEnum.Expression));
            break;
            case 3 :
            setType(value.wGetAdapter(PatternsEntityDescriptorEnum.Type));
            break;
            case 4 :
            setResultType(value.wGetAdapter(PatternsEntityDescriptorEnum.Type));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
