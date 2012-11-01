package org.whole.lang.dbcfg.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class JDBCDriversStrictImpl extends
		AbstractSetCompositeEntity<JDBCDriver> implements JDBCDrivers {
	private static final long serialVersionUID = 1;

	public void accept(IDBCFGVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return DBCFGEntityDescriptorEnum.JDBCDrivers_ord;
	}

	public EntityDescriptor<JDBCDrivers> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.JDBCDrivers;
	}
}
