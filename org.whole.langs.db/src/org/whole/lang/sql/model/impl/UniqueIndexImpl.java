package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;

/** 
 * @generator Whole
 */
public class UniqueIndexImpl extends AbstractSimpleEntity implements
		UniqueIndex {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<UniqueIndex> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.UniqueIndex;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.UniqueIndex_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}
}
