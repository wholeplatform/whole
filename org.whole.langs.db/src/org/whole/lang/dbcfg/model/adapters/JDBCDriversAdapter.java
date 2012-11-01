package org.whole.lang.dbcfg.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class JDBCDriversAdapter extends AbstractSetEntityAdapter<JDBCDriver>
		implements JDBCDrivers {
	private static final long serialVersionUID = 1;

	public JDBCDriversAdapter(IEntity implementor) {
		super(implementor);
	}

	public JDBCDriversAdapter() {
	}

	public void accept(IDBCFGVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<JDBCDrivers> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.JDBCDrivers;
	}
}
