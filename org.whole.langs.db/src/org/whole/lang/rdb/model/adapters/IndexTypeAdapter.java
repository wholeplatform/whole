package org.whole.lang.rdb.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.model.IndexTypeEnum.Value;

/** 
 * @generator Whole
 */
public class IndexTypeAdapter extends AbstractEntityAdapter implements
		IndexType {
	private static final long serialVersionUID = 1;

	public IndexTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public IndexTypeAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IndexType> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.IndexType;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
