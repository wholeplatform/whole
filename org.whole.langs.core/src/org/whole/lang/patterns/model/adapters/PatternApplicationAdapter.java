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
public class PatternApplicationAdapter extends AbstractEntityAdapter implements PatternApplication {
    private static final long serialVersionUID = 1;

    public PatternApplicationAdapter(IEntity implementor) {
        super(implementor);
    }

    public PatternApplicationAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PatternApplication> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.PatternApplication;
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
