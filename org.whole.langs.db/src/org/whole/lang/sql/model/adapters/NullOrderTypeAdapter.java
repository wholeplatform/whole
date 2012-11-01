package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.model.NullOrderTypeEnum.Value;

/** 
 * @generator Whole
 */
public class NullOrderTypeAdapter extends AbstractEntityAdapter implements
		NullOrderType {
	private static final long serialVersionUID = 1;

	public NullOrderTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public NullOrderTypeAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<NullOrderType> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.NullOrderType;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
