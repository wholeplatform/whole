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
public class DatabaseNameAdapter extends AbstractEntityAdapter implements
		DatabaseName {
	private static final long serialVersionUID = 1;

	public DatabaseNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public DatabaseNameAdapter() {
	}

	public void accept(IDBCFGVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DatabaseName> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.DatabaseName;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
