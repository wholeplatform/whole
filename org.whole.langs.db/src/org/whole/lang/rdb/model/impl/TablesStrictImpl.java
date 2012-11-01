package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class TablesStrictImpl extends AbstractSetCompositeEntity<Table>
		implements Tables {
	private static final long serialVersionUID = 1;

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.Tables_ord;
	}

	public EntityDescriptor<Tables> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Tables;
	}
}
