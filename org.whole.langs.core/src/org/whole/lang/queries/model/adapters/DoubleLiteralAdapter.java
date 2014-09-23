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
public class DoubleLiteralAdapter extends AbstractEntityAdapter implements DoubleLiteral {
    private static final long serialVersionUID = 1;

    public DoubleLiteralAdapter(IEntity implementor) {
        super(implementor);
    }

    public DoubleLiteralAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<DoubleLiteral> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.DoubleLiteral;
    }

    public double getValue() {
        return wDoubleValue();
    }

    public void setValue(double value) {
        wSetValue(value);
    }
}
