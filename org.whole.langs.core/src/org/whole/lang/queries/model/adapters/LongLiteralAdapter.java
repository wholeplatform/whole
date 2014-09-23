package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class LongLiteralAdapter extends AbstractEntityAdapter implements LongLiteral {
    private static final long serialVersionUID = 1;

    public LongLiteralAdapter(IEntity implementor) {
        super(implementor);
    }

    public LongLiteralAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<LongLiteral> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.LongLiteral;
    }

    public long getValue() {
        return wLongValue();
    }

    public void setValue(long value) {
        wSetValue(value);
    }
}
