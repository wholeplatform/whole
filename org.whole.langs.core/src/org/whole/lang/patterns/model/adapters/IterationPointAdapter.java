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
public class IterationPointAdapter extends AbstractEntityAdapter implements IterationPoint {
    private static final long serialVersionUID = 1;

    public IterationPointAdapter(IEntity implementor) {
        super(implementor);
    }

    public IterationPointAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<IterationPoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.IterationPoint;
    }

    public PathExpression getIterator() {
        return wGet(PatternsFeatureDescriptorEnum.iterator).wGetAdapter(PatternsEntityDescriptorEnum.PathExpression);
    }

    public void setIterator(PathExpression iterator) {
        wSet(PatternsFeatureDescriptorEnum.iterator, iterator);
    }

    public Template getTemplate() {
        return wGet(PatternsFeatureDescriptorEnum.template).wGetAdapter(PatternsEntityDescriptorEnum.Template);
    }

    public void setTemplate(Template template) {
        wSet(PatternsFeatureDescriptorEnum.template, template);
    }
}
