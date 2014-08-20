package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ResultTypeAdapter extends AbstractEntityAdapter implements ResultType {
    private static final long serialVersionUID = 1;

    public ResultTypeAdapter(IEntity implementor) {
        super(implementor);
    }

    public ResultTypeAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ResultType> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.ResultType;
    }
}
