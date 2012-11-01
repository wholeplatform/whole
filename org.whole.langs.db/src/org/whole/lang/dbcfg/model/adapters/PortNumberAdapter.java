package org.whole.lang.dbcfg.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PortNumberAdapter extends AbstractEntityAdapter implements
		PortNumber {
	private static final long serialVersionUID = 1;

	public PortNumberAdapter(IEntity implementor) {
		super(implementor);
	}

	public PortNumberAdapter() {
	}

	public void accept(IDBCFGVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PortNumber> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.PortNumber;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
