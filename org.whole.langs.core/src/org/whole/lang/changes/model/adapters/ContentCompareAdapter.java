package org.whole.lang.changes.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.changes.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ContentCompareAdapter extends AbstractEntityAdapter implements ContentCompare {
    private static final long serialVersionUID = 1;

    public ContentCompareAdapter(IEntity implementor) {
        super(implementor);
    }

    public ContentCompareAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ContentCompare> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.ContentCompare;
    }
}
