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
public class EntityTemplateImpl extends AbstractSimpleEntity implements EntityTemplate {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<EntityTemplate> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.EntityTemplate;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.EntityTemplate_ord;
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
    private Constraints constraints;

    public Constraints getConstraints() {
        return notifyRequested(QueriesFeatureDescriptorEnum.constraints, constraints);
    }

    public void setConstraints(Constraints constraints) {
        notifyChanged(QueriesFeatureDescriptorEnum.constraints, this.constraints, this.constraints = constraints);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getConstraints().wGetAdaptee(false);
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
            setConstraints(value.wGetAdapter(QueriesEntityDescriptorEnum.Constraints));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
