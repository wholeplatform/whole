package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.model.KindTestEnum.Value;

/**
 *  @generator  Whole
 */
public class KindTestAdapter extends AbstractEntityAdapter implements KindTest {
    private static final long serialVersionUID = 1;

    public KindTestAdapter(IEntity implementor) {
        super(implementor);
    }

    public KindTestAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<KindTest> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.KindTest;
    }

    public Value getValue() {
        return (Value) wEnumValue();
    }

    public void setValue(Value value) {
        wSetValue(value);
    }
}
