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
public class TinyIntValueAdapter extends AbstractEntityAdapter implements TinyIntValue {
	private static final long serialVersionUID = 1;

	public TinyIntValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public TinyIntValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TinyIntValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.TinyIntValue;
	}

	public byte getValue() {
		return wByteValue();
	}

	public void setValue(byte value) {
		wSetValue(value);
	}
}
