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
public class ClipboardAdapter extends AbstractEntityAdapter implements Clipboard {
    private static final long serialVersionUID = 1;

    public ClipboardAdapter(IEntity implementor) {
        super(implementor);
    }

    public ClipboardAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Clipboard> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Clipboard;
    }

    public int getValue() {
        return wIntValue();
    }

    public void setValue(int value) {
        wSetValue(value);
    }
}
