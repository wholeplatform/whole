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
public class ExtendedSubtypeTestAdapter extends AbstractEntityAdapter implements ExtendedSubtypeTest {
    private static final long serialVersionUID = 1;

    public ExtendedSubtypeTestAdapter(IEntity implementor) {
        super(implementor);
    }

    public ExtendedSubtypeTestAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ExtendedSubtypeTest> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.ExtendedSubtypeTest;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
