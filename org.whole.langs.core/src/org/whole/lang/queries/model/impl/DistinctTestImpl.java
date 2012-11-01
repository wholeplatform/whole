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
public class DistinctTestImpl extends AbstractSimpleEntity implements
		DistinctTest {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DistinctTest> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.DistinctTest;
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.DistinctTest_ord;
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	private Comparator comparator;

	public Comparator getComparator() {
		return notifyRequested(QueriesFeatureDescriptorEnum.comparator,
				comparator);
	}

	public void setComparator(Comparator comparator) {
		notifyChanged(QueriesFeatureDescriptorEnum.comparator, this.comparator,
				this.comparator = comparator);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getComparator().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setComparator(value
					.wGetAdapter(QueriesEntityDescriptorEnum.Comparator));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
