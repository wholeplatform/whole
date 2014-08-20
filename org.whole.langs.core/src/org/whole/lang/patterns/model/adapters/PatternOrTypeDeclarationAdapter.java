package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class PatternOrTypeDeclarationAdapter extends AbstractEntityAdapter implements PatternOrTypeDeclaration {
    private static final long serialVersionUID = 1;

    public PatternOrTypeDeclarationAdapter(IEntity implementor) {
        super(implementor);
    }

    public PatternOrTypeDeclarationAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PatternOrTypeDeclaration> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.PatternOrTypeDeclaration;
    }
}
