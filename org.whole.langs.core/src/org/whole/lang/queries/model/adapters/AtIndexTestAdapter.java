package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AtIndexTestAdapter extends AbstractEntityAdapter implements
		AtIndexTest {
	private static final long serialVersionUID = 1;

	public AtIndexTestAdapter(IEntity implementor) {
		super(implementor);
	}

	public AtIndexTestAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AtIndexTest> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.AtIndexTest;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
