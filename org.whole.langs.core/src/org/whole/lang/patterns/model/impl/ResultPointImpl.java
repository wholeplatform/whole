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
public class ResultPointImpl extends AbstractSimpleEntity implements ResultPoint {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ResultPoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.ResultPoint;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.ResultPoint_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }
    private Type resultType;

    public Type getResultType() {
        return notifyRequested(PatternsFeatureDescriptorEnum.resultType, resultType);
    }

    public void setResultType(Type resultType) {
        notifyChanged(PatternsFeatureDescriptorEnum.resultType, this.resultType, this.resultType = resultType);
    }
    private Template template;

    public Template getTemplate() {
        return notifyRequested(PatternsFeatureDescriptorEnum.template, template);
    }

    public void setTemplate(Template template) {
        notifyChanged(PatternsFeatureDescriptorEnum.template, this.template, this.template = template);
    }
    private PathExpression weaver;

    public PathExpression getWeaver() {
        return notifyRequested(PatternsFeatureDescriptorEnum.weaver, weaver);
    }

    public void setWeaver(PathExpression weaver) {
        notifyChanged(PatternsFeatureDescriptorEnum.weaver, this.weaver, this.weaver = weaver);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getResultType().wGetAdaptee(false);
            case 1 :
            return getTemplate().wGetAdaptee(false);
            case 2 :
            return getWeaver().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setResultType(value.wGetAdapter(PatternsEntityDescriptorEnum.Type));
            break;
            case 1 :
            setTemplate(value.wGetAdapter(PatternsEntityDescriptorEnum.Template));
            break;
            case 2 :
            setWeaver(value.wGetAdapter(PatternsEntityDescriptorEnum.PathExpression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
