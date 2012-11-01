package org.whole.lang.rdb.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.model.DeferrabilityEnum.Value;

/** 
 * @generator Whole
 */
public class DeferrabilityAdapter extends AbstractEntityAdapter implements
		Deferrability {
	private static final long serialVersionUID = 1;

	public DeferrabilityAdapter(IEntity implementor) {
		super(implementor);
	}

	public DeferrabilityAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Deferrability> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Deferrability;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
