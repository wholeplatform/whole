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
public class ConditionPointAdapter extends AbstractEntityAdapter implements ConditionPoint {
    private static final long serialVersionUID = 1;

    public ConditionPointAdapter(IEntity implementor) {
        super(implementor);
    }

    public ConditionPointAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ConditionPoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.ConditionPoint;
    }

    public Predicate getCondition() {
        return wGet(PatternsFeatureDescriptorEnum.condition).wGetAdapter(PatternsEntityDescriptorEnum.Predicate);
    }

    public void setCondition(Predicate condition) {
        wSet(PatternsFeatureDescriptorEnum.condition, condition);
    }

    public Template getTemplate() {
        return wGet(PatternsFeatureDescriptorEnum.template).wGetAdapter(PatternsEntityDescriptorEnum.Template);
    }

    public void setTemplate(Template template) {
        wSet(PatternsFeatureDescriptorEnum.template, template);
    }
}
