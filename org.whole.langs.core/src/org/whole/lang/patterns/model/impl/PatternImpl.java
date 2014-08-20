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
public class PatternImpl extends AbstractSimpleEntity implements Pattern {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Pattern> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Pattern;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.Pattern_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }
    private ResultTypes resultTypes;

    public ResultTypes getResultTypes() {
        return notifyRequested(PatternsFeatureDescriptorEnum.resultTypes, resultTypes);
    }

    public void setResultTypes(ResultTypes resultTypes) {
        notifyChanged(PatternsFeatureDescriptorEnum.resultTypes, this.resultTypes, this.resultTypes = resultTypes);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(PatternsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(PatternsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Template template;

    public Template getTemplate() {
        return notifyRequested(PatternsFeatureDescriptorEnum.template, template);
    }

    public void setTemplate(Template template) {
        notifyChanged(PatternsFeatureDescriptorEnum.template, this.template, this.template = template);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getResultTypes().wGetAdaptee(false);
            case 1 :
            return getName().wGetAdaptee(false);
            case 2 :
            return getTemplate().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setResultTypes(value.wGetAdapter(PatternsEntityDescriptorEnum.ResultTypes));
            break;
            case 1 :
            setName(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            case 2 :
            setTemplate(value.wGetAdapter(PatternsEntityDescriptorEnum.Template));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
