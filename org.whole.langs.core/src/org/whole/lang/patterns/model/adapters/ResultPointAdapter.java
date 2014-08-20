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
public class ResultPointAdapter extends AbstractEntityAdapter implements ResultPoint {
    private static final long serialVersionUID = 1;

    public ResultPointAdapter(IEntity implementor) {
        super(implementor);
    }

    public ResultPointAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ResultPoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.ResultPoint;
    }

    public Type getResultType() {
        return wGet(PatternsFeatureDescriptorEnum.resultType).wGetAdapter(PatternsEntityDescriptorEnum.Type);
    }

    public void setResultType(Type resultType) {
        wSet(PatternsFeatureDescriptorEnum.resultType, resultType);
    }

    public Template getTemplate() {
        return wGet(PatternsFeatureDescriptorEnum.template).wGetAdapter(PatternsEntityDescriptorEnum.Template);
    }

    public void setTemplate(Template template) {
        wSet(PatternsFeatureDescriptorEnum.template, template);
    }

    public PathExpression getWeaver() {
        return wGet(PatternsFeatureDescriptorEnum.weaver).wGetAdapter(PatternsEntityDescriptorEnum.PathExpression);
    }

    public void setWeaver(PathExpression weaver) {
        wSet(PatternsFeatureDescriptorEnum.weaver, weaver);
    }
}
