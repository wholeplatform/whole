package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import java.math.BigDecimal;

/** 
 * @generator Whole
 */
public class DecimalValueAdapter extends AbstractEntityAdapter implements DecimalValue {
	private static final long serialVersionUID = 1;

	public DecimalValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public DecimalValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DecimalValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.DecimalValue;
	}

	public BigDecimal getValue() {
		return (BigDecimal) wGetValue();
	}

	public void setValue(BigDecimal value) {
		wSetValue((Object) value);
	}
}
