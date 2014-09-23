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
public class AtFeatureTestAdapter extends AbstractEntityAdapter implements AtFeatureTest {
    private static final long serialVersionUID = 1;

    public AtFeatureTestAdapter(IEntity implementor) {
        super(implementor);
    }

    public AtFeatureTestAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<AtFeatureTest> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.AtFeatureTest;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
