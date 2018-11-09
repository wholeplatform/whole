package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import java.sql.Date;

/** 
 * @generator Whole
 */
public class DateValueAdapter extends AbstractEntityAdapter implements DateValue {
	private static final long serialVersionUID = 1;

	public DateValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public DateValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DateValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.DateValue;
	}

	public Date getValue() {
		return (Date) wGetValue();
	}

	public void setValue(Date value) {
		wSetValue((Object) value);
	}
}
