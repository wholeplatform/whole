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
package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.Enumeration;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.patterns.model.Name;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.model.Type;
import org.whole.lang.patterns.model.EnumValues;
import org.whole.lang.patterns.model.ResultTypes;

/**
 *  @generator Whole
 */
public class EnumerationImpl extends AbstractSimpleEntity implements Enumeration {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Enumeration> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Enumeration;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.Enumeration_ord;
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
    private Type resultType;

    public Type getResultType() {
        return notifyRequested(PatternsFeatureDescriptorEnum.resultType, resultType);
    }

    public void setResultType(Type resultType) {
        notifyChanged(PatternsFeatureDescriptorEnum.resultType, this.resultType, this.resultType = resultType);
    }
    private EnumValues values;

    public EnumValues getValues() {
        return notifyRequested(PatternsFeatureDescriptorEnum.values, values);
    }

    public void setValues(EnumValues values) {
        notifyChanged(PatternsFeatureDescriptorEnum.values, this.values, this.values = values);
    }
    private ResultTypes supertypes;

    public ResultTypes getSupertypes() {
        return notifyRequested(PatternsFeatureDescriptorEnum.supertypes, supertypes);
    }

    public void setSupertypes(ResultTypes supertypes) {
        notifyChanged(PatternsFeatureDescriptorEnum.supertypes, this.supertypes, this.supertypes = supertypes);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getResultType().wGetAdaptee(false);
            case 2 :
            return getValues().wGetAdaptee(false);
            case 3 :
            return getSupertypes().wGetAdaptee(false);
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
            setResultType(value.wGetAdapter(PatternsEntityDescriptorEnum.Type));
            break;
            case 2 :
            setValues(value.wGetAdapter(PatternsEntityDescriptorEnum.EnumValues));
            break;
            case 3 :
            setSupertypes(value.wGetAdapter(PatternsEntityDescriptorEnum.ResultTypes));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
