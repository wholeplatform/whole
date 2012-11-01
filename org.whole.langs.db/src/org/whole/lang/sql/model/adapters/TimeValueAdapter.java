package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import java.sql.Time;

/** 
 * @generator Whole
 */
public class TimeValueAdapter extends AbstractEntityAdapter implements
		TimeValue {
	private static final long serialVersionUID = 1;

	public TimeValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public TimeValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TimeValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.TimeValue;
	}

	public Time getValue() {
		return (Time) wGetValue();
	}

	public void setValue(Time value) {
		wSetValue((Object) value);
	}
}
