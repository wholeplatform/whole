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
public class DatabaseSchemaAdapter extends AbstractEntityAdapter implements
		DatabaseSchema {
	private static final long serialVersionUID = 1;

	public DatabaseSchemaAdapter(IEntity implementor) {
		super(implementor);
	}

	public DatabaseSchemaAdapter() {
	}

	public void accept(IDBCFGVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DatabaseSchema> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.DatabaseSchema;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
