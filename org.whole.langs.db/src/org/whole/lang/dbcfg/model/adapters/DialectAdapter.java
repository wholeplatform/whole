package org.whole.lang.dbcfg.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.dbcfg.model.DialectEnum.Value;

/** 
 * @generator Whole
 */
public class DialectAdapter extends AbstractEntityAdapter implements Dialect {
	private static final long serialVersionUID = 1;

	public DialectAdapter(IEntity implementor) {
		super(implementor);
	}

	public DialectAdapter() {
	}

	public void accept(IDBCFGVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Dialect> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.Dialect;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
