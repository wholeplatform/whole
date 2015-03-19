package org.whole.lang.dbcfg.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DataSourcesImpl extends AbstractListCompositeEntity<DataSource>
		implements DataSources {
	private static final long serialVersionUID = 1;

	public void accept(IDBCFGVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return DBCFGEntityDescriptorEnum.DataSources_ord;
	}

	public EntityDescriptor<DataSources> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.DataSources;
	}
}
