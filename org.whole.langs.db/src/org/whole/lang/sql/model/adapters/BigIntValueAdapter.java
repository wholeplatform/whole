package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class BigIntValueAdapter extends AbstractEntityAdapter implements
		BigIntValue {
	private static final long serialVersionUID = 1;

	public BigIntValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public BigIntValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BigIntValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.BigIntValue;
	}

	public long getValue() {
		return wLongValue();
	}

	public void setValue(long value) {
		wSetValue(value);
	}
}
