package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import java.sql.Timestamp;

/** 
 * @generator Whole
 */
public class TimestampValueAdapter extends AbstractEntityAdapter implements
		TimestampValue {
	private static final long serialVersionUID = 1;

	public TimestampValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public TimestampValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TimestampValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.TimestampValue;
	}

	public Timestamp getValue() {
		return (Timestamp) wGetValue();
	}

	public void setValue(Timestamp value) {
		wSetValue((Object) value);
	}
}
