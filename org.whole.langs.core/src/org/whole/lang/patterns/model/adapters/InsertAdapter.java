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
public class InsertAdapter extends AbstractEntityAdapter implements Insert {
    private static final long serialVersionUID = 1;

    public InsertAdapter(IEntity implementor) {
        super(implementor);
    }

    public InsertAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Insert> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Insert;
    }

    public Placement getPlacement() {
        return wGet(PatternsFeatureDescriptorEnum.placement).wGetAdapter(PatternsEntityDescriptorEnum.Placement);
    }

    public void setPlacement(Placement placement) {
        wSet(PatternsFeatureDescriptorEnum.placement, placement);
    }

    public PathExpression getPath() {
        return wGet(PatternsFeatureDescriptorEnum.path).wGetAdapter(PatternsEntityDescriptorEnum.PathExpression);
    }

    public void setPath(PathExpression path) {
        wSet(PatternsFeatureDescriptorEnum.path, path);
    }
}
