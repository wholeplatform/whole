package org.whole.lang.dbcfg.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DataSourcesAdapter extends AbstractListEntityAdapter<DataSource>
		implements DataSources {
	private static final long serialVersionUID = 1;

	public DataSourcesAdapter(IEntity implementor) {
		super(implementor);
	}

	public DataSourcesAdapter() {
	}

	public void accept(IDBCFGVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DataSources> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.DataSources;
	}
}
