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
public class InlinePointImpl extends AbstractSimpleEntity implements InlinePoint {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<InlinePoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.InlinePoint;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.InlinePoint_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
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
            return getTemplate().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setTemplate(value.wGetAdapter(PatternsEntityDescriptorEnum.Template));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
