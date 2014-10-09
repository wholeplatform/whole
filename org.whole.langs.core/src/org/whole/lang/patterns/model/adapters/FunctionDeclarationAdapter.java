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
public class FunctionDeclarationAdapter extends AbstractEntityAdapter implements FunctionDeclaration {
    private static final long serialVersionUID = 1;

    public FunctionDeclarationAdapter(IEntity implementor) {
        super(implementor);
    }

    public FunctionDeclarationAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<FunctionDeclaration> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.FunctionDeclaration;
    }

    public ResultTypes getApplicationTypes() {
        return wGet(PatternsFeatureDescriptorEnum.applicationTypes).wGetAdapter(PatternsEntityDescriptorEnum.ResultTypes);
    }

    public void setApplicationTypes(ResultTypes applicationTypes) {
        wSet(PatternsFeatureDescriptorEnum.applicationTypes, applicationTypes);
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
