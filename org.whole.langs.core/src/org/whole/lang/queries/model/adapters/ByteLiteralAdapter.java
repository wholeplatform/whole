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
public class ByteLiteralAdapter extends AbstractEntityAdapter implements
		ByteLiteral {
	private static final long serialVersionUID = 1;

	public ByteLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public ByteLiteralAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ByteLiteral> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.ByteLiteral;
	}

	public byte getValue() {
		return wByteValue();
	}

	public void setValue(byte value) {
		wSetValue(value);
	}
}
