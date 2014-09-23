package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.model.StageTestEnum.Value;

/**
 *  @generator  Whole
 */
public class StageTestAdapter extends AbstractEntityAdapter implements StageTest {
    private static final long serialVersionUID = 1;

    public StageTestAdapter(IEntity implementor) {
        super(implementor);
    }

    public StageTestAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<StageTest> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.StageTest;
    }

    public Value getValue() {
        return (Value) wEnumValue();
    }

    public void setValue(Value value) {
        wSetValue(value);
    }
}
