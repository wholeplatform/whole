package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.model.IsTypeEnum.Value;

/** 
 * @generator Whole
 */
public class IsTypeAdapter extends AbstractEntityAdapter implements IsType {
	private static final long serialVersionUID = 1;

	public IsTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public IsTypeAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IsType> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.IsType;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
