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
public class IndexAdapter extends AbstractEntityAdapter implements Index {
	private static final long serialVersionUID = 1;

	public IndexAdapter(IEntity implementor) {
		super(implementor);
	}

	public IndexAdapter() {
	}

	public void accept(IDBCFGVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Index> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.Index;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
