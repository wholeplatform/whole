package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class VisitorTestAdapter extends AbstractEntityAdapter implements
		VisitorTest {
	private static final long serialVersionUID = 1;

	public VisitorTestAdapter(IEntity implementor) {
		super(implementor);
	}

	public VisitorTestAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VisitorTest> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.VisitorTest;
	}

	public IVisitor getValue() {
		return (IVisitor) wGetValue();
	}

	public void setValue(IVisitor value) {
		wSetValue((Object) value);
	}
}
