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
public class EnumValueAdapter extends AbstractEntityAdapter implements EnumValue {
    private static final long serialVersionUID = 1;

    public EnumValueAdapter(IEntity implementor) {
        super(implementor);
    }

    public EnumValueAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<EnumValue> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.EnumValue;
    }

    public Name getValue() {
        return wGet(PatternsFeatureDescriptorEnum.value).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setValue(Name value) {
        wSet(PatternsFeatureDescriptorEnum.value, value);
    }

    public Name getResult() {
        return wGet(PatternsFeatureDescriptorEnum.result).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setResult(Name result) {
        wSet(PatternsFeatureDescriptorEnum.result, result);
    }
}
