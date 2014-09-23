package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class EntityCallImpl extends AbstractSimpleEntity implements EntityCall {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<EntityCall> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.EntityCall;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.EntityCall_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }
    private EntityType name;

    public EntityType getName() {
        return notifyRequested(QueriesFeatureDescriptorEnum.name, name);
    }

    public void setName(EntityType name) {
        notifyChanged(QueriesFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Bindings bindings;

    public Bindings getBindings() {
        return notifyRequested(QueriesFeatureDescriptorEnum.bindings, bindings);
    }

    public void setBindings(Bindings bindings) {
        notifyChanged(QueriesFeatureDescriptorEnum.bindings, this.bindings, this.bindings = bindings);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getBindings().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(QueriesEntityDescriptorEnum.EntityType));
            break;
            case 1 :
            setBindings(value.wGetAdapter(QueriesEntityDescriptorEnum.Bindings));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
