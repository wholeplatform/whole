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
import org.whole.lang.patterns.model.Data;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.patterns.model.ResultTypes;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.model.Name;
import org.whole.lang.patterns.model.DataType;

/**
 *  @generator Whole
 */
public class DataImpl extends AbstractSimpleEntity implements Data {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Data> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Data;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.Data_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private ResultTypes supertypes;

    public ResultTypes getSupertypes() {
        return notifyRequested(PatternsFeatureDescriptorEnum.supertypes, supertypes);
    }

    public void setSupertypes(ResultTypes supertypes) {
        notifyChanged(PatternsFeatureDescriptorEnum.supertypes, this.supertypes, this.supertypes = supertypes);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(PatternsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(PatternsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private DataType dataType;

    public DataType getDataType() {
        return notifyRequested(PatternsFeatureDescriptorEnum.dataType, dataType);
    }

    public void setDataType(DataType dataType) {
        notifyChanged(PatternsFeatureDescriptorEnum.dataType, this.dataType, this.dataType = dataType);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSupertypes().wGetAdaptee(false);
            case 1 :
            return getName().wGetAdaptee(false);
            case 2 :
            return getDataType().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSupertypes(value.wGetAdapter(PatternsEntityDescriptorEnum.ResultTypes));
            break;
            case 1 :
            setName(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            case 2 :
            setDataType(value.wGetAdapter(PatternsEntityDescriptorEnum.DataType));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
