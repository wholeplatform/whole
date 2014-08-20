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
public class EnumerationAdapter extends AbstractEntityAdapter implements Enumeration {
    private static final long serialVersionUID = 1;

    public EnumerationAdapter(IEntity implementor) {
        super(implementor);
    }

    public EnumerationAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Enumeration> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Enumeration;
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public Type getResultType() {
        return wGet(PatternsFeatureDescriptorEnum.resultType).wGetAdapter(PatternsEntityDescriptorEnum.Type);
    }

    public void setResultType(Type resultType) {
        wSet(PatternsFeatureDescriptorEnum.resultType, resultType);
    }

    public EnumValues getValues() {
        return wGet(PatternsFeatureDescriptorEnum.values).wGetAdapter(PatternsEntityDescriptorEnum.EnumValues);
    }

    public void setValues(EnumValues values) {
        wSet(PatternsFeatureDescriptorEnum.values, values);
    }

    public ResultTypes getSupertypes() {
        return wGet(PatternsFeatureDescriptorEnum.supertypes).wGetAdapter(PatternsEntityDescriptorEnum.ResultTypes);
    }

    public void setSupertypes(ResultTypes supertypes) {
        wSet(PatternsFeatureDescriptorEnum.supertypes, supertypes);
    }
}
