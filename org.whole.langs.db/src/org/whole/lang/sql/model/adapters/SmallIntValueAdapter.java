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
public class SmallIntValueAdapter extends AbstractEntityAdapter implements
		SmallIntValue {
	private static final long serialVersionUID = 1;

	public SmallIntValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public SmallIntValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SmallIntValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.SmallIntValue;
	}

	public short getValue() {
		return wShortValue();
	}

	public void setValue(short value) {
		wSetValue(value);
	}
}
