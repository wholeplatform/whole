package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.UniqueIndex;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;

/** 
 * @generator Whole
 */
public class UniqueIndexImpl extends AbstractSimpleEntity implements UniqueIndex {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<UniqueIndex> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.UniqueIndex;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.UniqueIndex_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
