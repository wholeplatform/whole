package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class IndexTestImpl extends AbstractSimpleEntity implements IndexTest {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IndexTest> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.IndexTest;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.IndexTest_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	private IntLiteral index;

	public IntLiteral getIndex() {
		return notifyRequested(QueriesFeatureDescriptorEnum.index, index);
	}

	public void setIndex(IntLiteral index) {
		notifyChanged(QueriesFeatureDescriptorEnum.index, this.index,
				this.index = index);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getIndex().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIndex(value.wGetAdapter(QueriesEntityDescriptorEnum.IntLiteral));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
