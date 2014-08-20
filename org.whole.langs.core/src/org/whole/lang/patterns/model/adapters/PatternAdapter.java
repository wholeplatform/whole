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
public class PatternAdapter extends AbstractEntityAdapter implements Pattern {
    private static final long serialVersionUID = 1;

    public PatternAdapter(IEntity implementor) {
        super(implementor);
    }

    public PatternAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Pattern> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Pattern;
    }

    public ResultTypes getResultTypes() {
        return wGet(PatternsFeatureDescriptorEnum.resultTypes).wGetAdapter(PatternsEntityDescriptorEnum.ResultTypes);
    }

    public void setResultTypes(ResultTypes resultTypes) {
        wSet(PatternsFeatureDescriptorEnum.resultTypes, resultTypes);
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public Template getTemplate() {
        return wGet(PatternsFeatureDescriptorEnum.template).wGetAdapter(PatternsEntityDescriptorEnum.Template);
    }

    public void setTemplate(Template template) {
        wSet(PatternsFeatureDescriptorEnum.template, template);
    }
}
