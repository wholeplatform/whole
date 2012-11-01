package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ColumnReferencesImpl extends
		AbstractListCompositeEntity<ColumnReference> implements
		ColumnReferences {
	private static final long serialVersionUID = 1;

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.ColumnReferences_ord;
	}

	public EntityDescriptor<ColumnReferences> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.ColumnReferences;
	}
}
