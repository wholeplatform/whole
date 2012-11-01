package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractUniqueListCompositeEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ColumnIndicesStrictImpl extends
		AbstractUniqueListCompositeEntity<ColumnIndex> implements ColumnIndices {
	private static final long serialVersionUID = 1;

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.ColumnIndices_ord;
	}

	public EntityDescriptor<ColumnIndices> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.ColumnIndices;
	}
}
