package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ForeignKeysImpl extends AbstractListCompositeEntity<ForeignKey>
		implements ForeignKeys {
	private static final long serialVersionUID = 1;

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.ForeignKeys_ord;
	}

	public EntityDescriptor<ForeignKeys> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.ForeignKeys;
	}
}
