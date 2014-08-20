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
public class SlotAdapter extends AbstractEntityAdapter implements Slot {
    private static final long serialVersionUID = 1;

    public SlotAdapter(IEntity implementor) {
        super(implementor);
    }

    public SlotAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Slot> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Slot;
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public BooleanValue getOptional() {
        return wGet(PatternsFeatureDescriptorEnum.optional).wGetAdapter(PatternsEntityDescriptorEnum.BooleanValue);
    }

    public void setOptional(BooleanValue optional) {
        wSet(PatternsFeatureDescriptorEnum.optional, optional);
    }

    public PathExpression getAdapter() {
        return wGet(PatternsFeatureDescriptorEnum.adapter).wGetAdapter(PatternsEntityDescriptorEnum.PathExpression);
    }

    public void setAdapter(PathExpression adapter) {
        wSet(PatternsFeatureDescriptorEnum.adapter, adapter);
    }

    public Type getType() {
        return wGet(PatternsFeatureDescriptorEnum.type).wGetAdapter(PatternsEntityDescriptorEnum.Type);
    }

    public void setType(Type type) {
        wSet(PatternsFeatureDescriptorEnum.type, type);
    }

    public Type getResultType() {
        return wGet(PatternsFeatureDescriptorEnum.resultType).wGetAdapter(PatternsEntityDescriptorEnum.Type);
    }

    public void setResultType(Type resultType) {
        wSet(PatternsFeatureDescriptorEnum.resultType, resultType);
    }
}
