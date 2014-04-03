package org.whole.lang.changes.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.changes.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ChangeSidesAdapter extends AbstractSetEntityAdapter<ChangeSide> implements ChangeSides {
    private static final long serialVersionUID = 1;

    public ChangeSidesAdapter(IEntity implementor) {
        super(implementor);
    }

    public ChangeSidesAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ChangeSides> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.ChangeSides;
    }
}
