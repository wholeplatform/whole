package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.model.BooleanOperatorEnum.Value;

/** 
 * @generator Whole
 */
public class BooleanOperatorAdapter extends AbstractEntityAdapter implements
		BooleanOperator {
	private static final long serialVersionUID = 1;

	public BooleanOperatorAdapter(IEntity implementor) {
		super(implementor);
	}

	public BooleanOperatorAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BooleanOperator> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.BooleanOperator;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
