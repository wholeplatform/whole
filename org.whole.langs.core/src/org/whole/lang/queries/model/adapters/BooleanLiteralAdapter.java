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
public class BooleanLiteralAdapter extends AbstractEntityAdapter implements BooleanLiteral {
    private static final long serialVersionUID = 1;

    public BooleanLiteralAdapter(IEntity implementor) {
        super(implementor);
    }

    public BooleanLiteralAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<BooleanLiteral> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.BooleanLiteral;
    }

    public boolean isValue() {
        return wBooleanValue();
    }

    public void setValue(boolean value) {
        wSetValue(value);
    }
}
