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
public class SlotImpl extends AbstractSimpleEntity implements Slot {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Slot> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Slot;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.Slot_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(PatternsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(PatternsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private BooleanValue optional;

    public BooleanValue getOptional() {
        return notifyRequested(PatternsFeatureDescriptorEnum.optional, optional);
    }

    public void setOptional(BooleanValue optional) {
        notifyChanged(PatternsFeatureDescriptorEnum.optional, this.optional, this.optional = optional);
    }
    private PathExpression adapter;

    public PathExpression getAdapter() {
        return notifyRequested(PatternsFeatureDescriptorEnum.adapter, adapter);
    }

    public void setAdapter(PathExpression adapter) {
        notifyChanged(PatternsFeatureDescriptorEnum.adapter, this.adapter, this.adapter = adapter);
    }
    private Type type;

    public Type getType() {
        return notifyRequested(PatternsFeatureDescriptorEnum.type, type);
    }

    public void setType(Type type) {
        notifyChanged(PatternsFeatureDescriptorEnum.type, this.type, this.type = type);
    }
    private Type resultType;

    public Type getResultType() {
        return notifyRequested(PatternsFeatureDescriptorEnum.resultType, resultType);
    }

    public void setResultType(Type resultType) {
        notifyChanged(PatternsFeatureDescriptorEnum.resultType, this.resultType, this.resultType = resultType);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getOptional().wGetAdaptee(false);
            case 2 :
            return getAdapter().wGetAdaptee(false);
            case 3 :
            return getType().wGetAdaptee(false);
            case 4 :
            return getResultType().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            case 1 :
            setOptional(value.wGetAdapter(PatternsEntityDescriptorEnum.BooleanValue));
            break;
            case 2 :
            setAdapter(value.wGetAdapter(PatternsEntityDescriptorEnum.PathExpression));
            break;
            case 3 :
            setType(value.wGetAdapter(PatternsEntityDescriptorEnum.Type));
            break;
            case 4 :
            setResultType(value.wGetAdapter(PatternsEntityDescriptorEnum.Type));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
