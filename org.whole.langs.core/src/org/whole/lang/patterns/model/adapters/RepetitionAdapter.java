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
public class RepetitionAdapter extends AbstractEntityAdapter implements Repetition {
    private static final long serialVersionUID = 1;

    public RepetitionAdapter(IEntity implementor) {
        super(implementor);
    }

    public RepetitionAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Repetition> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Repetition;
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public Type getType() {
        return wGet(PatternsFeatureDescriptorEnum.type).wGetAdapter(PatternsEntityDescriptorEnum.Type);
    }

    public void setType(Type type) {
        wSet(PatternsFeatureDescriptorEnum.type, type);
    }

    public ResultTypes getSupertypes() {
        return wGet(PatternsFeatureDescriptorEnum.supertypes).wGetAdapter(PatternsEntityDescriptorEnum.ResultTypes);
    }

    public void setSupertypes(ResultTypes supertypes) {
        wSet(PatternsFeatureDescriptorEnum.supertypes, supertypes);
    }
}
