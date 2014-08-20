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
public class ChoiceAdapter extends AbstractEntityAdapter implements Choice {
    private static final long serialVersionUID = 1;

    public ChoiceAdapter(IEntity implementor) {
        super(implementor);
    }

    public ChoiceAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Choice> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Choice;
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public Types getTypes() {
        return wGet(PatternsFeatureDescriptorEnum.types).wGetAdapter(PatternsEntityDescriptorEnum.Types);
    }

    public void setTypes(Types types) {
        wSet(PatternsFeatureDescriptorEnum.types, types);
    }

    public ResultTypes getSupertypes() {
        return wGet(PatternsFeatureDescriptorEnum.supertypes).wGetAdapter(PatternsEntityDescriptorEnum.ResultTypes);
    }

    public void setSupertypes(ResultTypes supertypes) {
        wSet(PatternsFeatureDescriptorEnum.supertypes, supertypes);
    }
}
