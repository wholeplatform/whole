package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import java.util.Date;

/** 
 * @generator Whole
 */
public class DateLiteralAdapter extends AbstractEntityAdapter implements
		DateLiteral {
	private static final long serialVersionUID = 1;

	public DateLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public DateLiteralAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DateLiteral> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.DateLiteral;
	}

	public Date getValue() {
		return wDateValue();
	}

	public void setValue(Date value) {
		wSetValue(value);
	}
}
