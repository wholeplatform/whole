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
public class FunctionApplicationPointAdapter extends AbstractEntityAdapter implements FunctionApplicationPoint {
    private static final long serialVersionUID = 1;

    public FunctionApplicationPointAdapter(IEntity implementor) {
        super(implementor);
    }

    public FunctionApplicationPointAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<FunctionApplicationPoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.FunctionApplicationPoint;
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
}
