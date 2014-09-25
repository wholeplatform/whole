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
public class GoalDeclarationImpl extends AbstractSimpleEntity implements GoalDeclaration {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<GoalDeclaration> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.GoalDeclaration;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.GoalDeclaration_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }
    private GoalExpression subgoals;

    public GoalExpression getSubgoals() {
        return notifyRequested(PatternsFeatureDescriptorEnum.subgoals, subgoals);
    }

    public void setSubgoals(GoalExpression subgoals) {
        notifyChanged(PatternsFeatureDescriptorEnum.subgoals, this.subgoals, this.subgoals = subgoals);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(PatternsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(PatternsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Expression body;

    public Expression getBody() {
        return notifyRequested(PatternsFeatureDescriptorEnum.body, body);
    }

    public void setBody(Expression body) {
        notifyChanged(PatternsFeatureDescriptorEnum.body, this.body, this.body = body);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSubgoals().wGetAdaptee(false);
            case 1 :
            return getName().wGetAdaptee(false);
            case 2 :
            return getBody().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSubgoals(value.wGetAdapter(PatternsEntityDescriptorEnum.GoalExpression));
            break;
            case 1 :
            setName(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            case 2 :
            setBody(value.wGetAdapter(PatternsEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
