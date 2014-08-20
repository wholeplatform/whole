package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class DataAdapter extends AbstractEntityAdapter implements Data {
    private static final long serialVersionUID = 1;

    public DataAdapter(IEntity implementor) {
        super(implementor);
    }

    public DataAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Data> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Data;
    }

    public ResultTypes getSupertypes() {
        return wGet(PatternsFeatureDescriptorEnum.supertypes).wGetAdapter(PatternsEntityDescriptorEnum.ResultTypes);
    }

    public void setSupertypes(ResultTypes supertypes) {
        wSet(PatternsFeatureDescriptorEnum.supertypes, supertypes);
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public DataType getDataType() {
        return wGet(PatternsFeatureDescriptorEnum.dataType).wGetAdapter(PatternsEntityDescriptorEnum.DataType);
    }

    public void setDataType(DataType dataType) {
        wSet(PatternsFeatureDescriptorEnum.dataType, dataType);
    }
}
