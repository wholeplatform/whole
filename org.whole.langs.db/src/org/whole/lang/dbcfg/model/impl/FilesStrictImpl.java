package org.whole.lang.dbcfg.model.impl;

import org.whole.lang.model.AbstractBagCompositeEntity;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FilesStrictImpl extends AbstractBagCompositeEntity<FilePath>
		implements Files {
	private static final long serialVersionUID = 1;

	public void accept(IDBCFGVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return DBCFGEntityDescriptorEnum.Files_ord;
	}

	public EntityDescriptor<Files> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.Files;
	}
}
