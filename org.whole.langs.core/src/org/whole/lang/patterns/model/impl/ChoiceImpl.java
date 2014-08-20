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
public class ChoiceImpl extends AbstractSimpleEntity implements Choice {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Choice> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Choice;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.Choice_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(PatternsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(PatternsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Types types;

    public Types getTypes() {
        return notifyRequested(PatternsFeatureDescriptorEnum.types, types);
    }

    public void setTypes(Types types) {
        notifyChanged(PatternsFeatureDescriptorEnum.types, this.types, this.types = types);
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
            return getTypes().wGetAdaptee(false);
            case 2 :
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
            setTypes(value.wGetAdapter(PatternsEntityDescriptorEnum.Types));
            break;
            case 2 :
            setSupertypes(value.wGetAdapter(PatternsEntityDescriptorEnum.ResultTypes));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
