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
public class IndexRangeTestAdapter extends AbstractEntityAdapter implements IndexRangeTest {
    private static final long serialVersionUID = 1;

    public IndexRangeTestAdapter(IEntity implementor) {
        super(implementor);
    }

    public IndexRangeTestAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<IndexRangeTest> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.IndexRangeTest;
    }

    public IntLiteral getStartIndex() {
        return wGet(QueriesFeatureDescriptorEnum.startIndex).wGetAdapter(QueriesEntityDescriptorEnum.IntLiteral);
    }

    public void setStartIndex(IntLiteral startIndex) {
        wSet(QueriesFeatureDescriptorEnum.startIndex, startIndex);
    }

    public IntLiteral getEndIndex() {
        return wGet(QueriesFeatureDescriptorEnum.endIndex).wGetAdapter(QueriesEntityDescriptorEnum.IntLiteral);
    }

    public void setEndIndex(IntLiteral endIndex) {
        wSet(QueriesFeatureDescriptorEnum.endIndex, endIndex);
    }
}
