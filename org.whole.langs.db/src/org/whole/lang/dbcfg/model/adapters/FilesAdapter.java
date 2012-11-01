package org.whole.lang.dbcfg.model.adapters;

import org.whole.lang.model.adapters.AbstractCollectionEntityAdapter;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FilesAdapter extends AbstractCollectionEntityAdapter<FilePath>
		implements Files {
	private static final long serialVersionUID = 1;

	public FilesAdapter(IEntity implementor) {
		super(implementor);
	}

	public FilesAdapter() {
	}

	public void accept(IDBCFGVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Files> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.Files;
	}
}
