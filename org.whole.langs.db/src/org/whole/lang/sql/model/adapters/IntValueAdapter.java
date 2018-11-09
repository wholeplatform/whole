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
public class IntValueAdapter extends AbstractEntityAdapter implements IntValue {
	private static final long serialVersionUID = 1;

	public IntValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public IntValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IntValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.IntValue;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
