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
public class ScopePointAdapter extends AbstractEntityAdapter implements ScopePoint {
    private static final long serialVersionUID = 1;

    public ScopePointAdapter(IEntity implementor) {
        super(implementor);
    }

    public ScopePointAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ScopePoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.ScopePoint;
    }

    public Declarations getContext() {
        return wGet(PatternsFeatureDescriptorEnum.context).wGetAdapter(PatternsEntityDescriptorEnum.Declarations);
    }

    public void setContext(Declarations context) {
        wSet(PatternsFeatureDescriptorEnum.context, context);
    }

    public Template getTemplate() {
        return wGet(PatternsFeatureDescriptorEnum.template).wGetAdapter(PatternsEntityDescriptorEnum.Template);
    }

    public void setTemplate(Template template) {
        wSet(PatternsFeatureDescriptorEnum.template, template);
    }
}
