package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractUniqueListCompositeEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ColumnsStrictImpl extends
		AbstractUniqueListCompositeEntity<Column> implements Columns {
	private static final long serialVersionUID = 1;

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.Columns_ord;
	}

	public EntityDescriptor<Columns> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Columns;
	}
}
