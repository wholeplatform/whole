package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class IndexRangeTestImpl extends AbstractSimpleEntity implements IndexRangeTest {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<IndexRangeTest> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.IndexRangeTest;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.IndexRangeTest_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        visitor.visit(this);
    }
    private IntLiteral startIndex;

    public IntLiteral getStartIndex() {
        return notifyRequested(QueriesFeatureDescriptorEnum.startIndex, startIndex);
    }

    public void setStartIndex(IntLiteral startIndex) {
        notifyChanged(QueriesFeatureDescriptorEnum.startIndex, this.startIndex, this.startIndex = startIndex);
    }
    private IntLiteral endIndex;

    public IntLiteral getEndIndex() {
        return notifyRequested(QueriesFeatureDescriptorEnum.endIndex, endIndex);
    }

    public void setEndIndex(IntLiteral endIndex) {
        notifyChanged(QueriesFeatureDescriptorEnum.endIndex, this.endIndex, this.endIndex = endIndex);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getStartIndex().wGetAdaptee(false);
            case 1 :
            return getEndIndex().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setStartIndex(value.wGetAdapter(QueriesEntityDescriptorEnum.IntLiteral));
            break;
            case 1 :
            setEndIndex(value.wGetAdapter(QueriesEntityDescriptorEnum.IntLiteral));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
