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
public class PatternInstanceAdapter extends AbstractEntityAdapter implements PatternInstance {
    private static final long serialVersionUID = 1;

    public PatternInstanceAdapter(IEntity implementor) {
        super(implementor);
    }

    public PatternInstanceAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PatternInstance> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.PatternInstance;
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public Arguments getArguments() {
        return wGet(PatternsFeatureDescriptorEnum.arguments).wGetAdapter(PatternsEntityDescriptorEnum.Arguments);
    }

    public void setArguments(Arguments arguments) {
        wSet(PatternsFeatureDescriptorEnum.arguments, arguments);
    }
}
