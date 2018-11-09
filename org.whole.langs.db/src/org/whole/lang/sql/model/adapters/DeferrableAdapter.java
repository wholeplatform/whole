package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.model.DeferrableEnum.Value;

/** 
 * @generator Whole
 */
public class DeferrableAdapter extends AbstractEntityAdapter implements Deferrable {
	private static final long serialVersionUID = 1;

	public DeferrableAdapter(IEntity implementor) {
		super(implementor);
	}

	public DeferrableAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Deferrable> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Deferrable;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
