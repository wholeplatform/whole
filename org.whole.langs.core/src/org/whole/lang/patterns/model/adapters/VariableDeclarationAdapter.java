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
public class VariableDeclarationAdapter extends AbstractEntityAdapter implements VariableDeclaration {
    private static final long serialVersionUID = 1;

    public VariableDeclarationAdapter(IEntity implementor) {
        super(implementor);
    }

    public VariableDeclarationAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<VariableDeclaration> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.VariableDeclaration;
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public Expression getExpression() {
        return wGet(PatternsFeatureDescriptorEnum.expression).wGetAdapter(PatternsEntityDescriptorEnum.Expression);
    }

    public void setExpression(Expression expression) {
        wSet(PatternsFeatureDescriptorEnum.expression, expression);
    }

    public Type getResultType() {
        return wGet(PatternsFeatureDescriptorEnum.resultType).wGetAdapter(PatternsEntityDescriptorEnum.Type);
    }

    public void setResultType(Type resultType) {
        wSet(PatternsFeatureDescriptorEnum.resultType, resultType);
    }
}
