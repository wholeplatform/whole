package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class NamesAdapter extends AbstractListEntityAdapter<Name> implements Names {
    private static final long serialVersionUID = 1;

    public NamesAdapter(IEntity implementor) {
        super(implementor);
    }

    public NamesAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Names> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Names;
    }
}
