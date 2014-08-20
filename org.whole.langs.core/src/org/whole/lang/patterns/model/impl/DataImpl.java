package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
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
        visitor.visit(this);
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
