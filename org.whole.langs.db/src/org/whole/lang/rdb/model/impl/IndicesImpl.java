package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class IndicesImpl extends AbstractListCompositeEntity<Index> implements
		Indices {
	private static final long serialVersionUID = 1;

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.Indices_ord;
	}

	public EntityDescriptor<Indices> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Indices;
	}
}
