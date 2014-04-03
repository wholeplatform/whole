package org.whole.lang.changes.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.changes.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.changes.reflect.ChangesFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class RevisionChangeAdapter extends AbstractEntityAdapter implements RevisionChange {
    private static final long serialVersionUID = 1;

    public RevisionChangeAdapter(IEntity implementor) {
        super(implementor);
    }

    public RevisionChangeAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<RevisionChange> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.RevisionChange;
    }

    public ChangeSides getSides() {
        return wGet(ChangesFeatureDescriptorEnum.sides).wGetAdapter(ChangesEntityDescriptorEnum.ChangeSides);
    }

    public void setSides(ChangeSides sides) {
        wSet(ChangesFeatureDescriptorEnum.sides, sides);
    }
}
