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
public class FunctionPointAdapter extends AbstractEntityAdapter implements FunctionPoint {
    private static final long serialVersionUID = 1;

    public FunctionPointAdapter(IEntity implementor) {
        super(implementor);
    }

    public FunctionPointAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<FunctionPoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.FunctionPoint;
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public ResultType getResultType() {
        return wGet(PatternsFeatureDescriptorEnum.resultType).wGetAdapter(PatternsEntityDescriptorEnum.ResultType);
    }

    public void setResultType(ResultType resultType) {
        wSet(PatternsFeatureDescriptorEnum.resultType, resultType);
    }

    public PathExpression getExpression() {
        return wGet(PatternsFeatureDescriptorEnum.expression).wGetAdapter(PatternsEntityDescriptorEnum.PathExpression);
    }

    public void setExpression(PathExpression expression) {
        wSet(PatternsFeatureDescriptorEnum.expression, expression);
    }
}
