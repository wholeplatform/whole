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
public class ServerNameAdapter extends AbstractEntityAdapter implements
		ServerName {
	private static final long serialVersionUID = 1;

	public ServerNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public ServerNameAdapter() {
	}

	public void accept(IDBCFGVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ServerName> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.ServerName;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
