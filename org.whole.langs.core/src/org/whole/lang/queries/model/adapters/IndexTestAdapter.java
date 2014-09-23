package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class IndexTestAdapter extends AbstractEntityAdapter implements IndexTest {
    private static final long serialVersionUID = 1;

    public IndexTestAdapter(IEntity implementor) {
        super(implementor);
    }

    public IndexTestAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<IndexTest> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.IndexTest;
    }

    public IntLiteral getIndex() {
        return wGet(QueriesFeatureDescriptorEnum.index).wGetAdapter(QueriesEntityDescriptorEnum.IntLiteral);
    }

    public void setIndex(IntLiteral index) {
        wSet(QueriesFeatureDescriptorEnum.index, index);
    }
}
