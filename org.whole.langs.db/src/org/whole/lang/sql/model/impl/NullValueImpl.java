package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;

/** 
 * @generator Whole
 */
public class NullValueImpl extends AbstractSimpleEntity implements NullValue {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<NullValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.NullValue;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.NullValue_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
