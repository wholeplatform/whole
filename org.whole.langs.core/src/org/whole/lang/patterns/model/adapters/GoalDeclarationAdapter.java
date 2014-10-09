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
public class GoalDeclarationAdapter extends AbstractEntityAdapter implements GoalDeclaration {
    private static final long serialVersionUID = 1;

    public GoalDeclarationAdapter(IEntity implementor) {
        super(implementor);
    }

    public GoalDeclarationAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<GoalDeclaration> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.GoalDeclaration;
    }

    public GoalExpression getSubgoals() {
        return wGet(PatternsFeatureDescriptorEnum.subgoals).wGetAdapter(PatternsEntityDescriptorEnum.GoalExpression);
    }

    public void setSubgoals(GoalExpression subgoals) {
        wSet(PatternsFeatureDescriptorEnum.subgoals, subgoals);
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public PathExpression getBody() {
        return wGet(PatternsFeatureDescriptorEnum.body).wGetAdapter(PatternsEntityDescriptorEnum.PathExpression);
    }

    public void setBody(PathExpression body) {
        wSet(PatternsFeatureDescriptorEnum.body, body);
    }
}
