package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class DistinctTestAdapter extends AbstractEntityAdapter implements
		DistinctTest {
	private static final long serialVersionUID = 1;

	public DistinctTestAdapter(IEntity implementor) {
		super(implementor);
	}

	public DistinctTestAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DistinctTest> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.DistinctTest;
	}

	public Comparator getComparator() {
		return wGet(QueriesFeatureDescriptorEnum.comparator).wGetAdapter(
				QueriesEntityDescriptorEnum.Comparator);
	}

	public void setComparator(Comparator comparator) {
		wSet(QueriesFeatureDescriptorEnum.comparator, comparator);
	}
}
