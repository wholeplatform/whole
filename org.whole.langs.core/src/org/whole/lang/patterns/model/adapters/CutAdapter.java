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
public class CutAdapter extends AbstractEntityAdapter implements Cut {
    private static final long serialVersionUID = 1;

    public CutAdapter(IEntity implementor) {
        super(implementor);
    }

    public CutAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Cut> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Cut;
    }

    public PathExpression getPath() {
        return wGet(PatternsFeatureDescriptorEnum.path).wGetAdapter(PatternsEntityDescriptorEnum.PathExpression);
    }

    public void setPath(PathExpression path) {
        wSet(PatternsFeatureDescriptorEnum.path, path);
    }
}
