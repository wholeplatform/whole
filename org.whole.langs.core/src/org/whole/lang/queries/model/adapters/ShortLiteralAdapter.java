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
public class ShortLiteralAdapter extends AbstractEntityAdapter implements ShortLiteral {
    private static final long serialVersionUID = 1;

    public ShortLiteralAdapter(IEntity implementor) {
        super(implementor);
    }

    public ShortLiteralAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ShortLiteral> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.ShortLiteral;
    }

    public short getValue() {
        return wShortValue();
    }

    public void setValue(short value) {
        wSetValue(value);
    }
}
