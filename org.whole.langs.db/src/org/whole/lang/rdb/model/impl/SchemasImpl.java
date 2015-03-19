package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SchemasImpl extends AbstractCollectionCompositeEntity<Schema>
		implements Schemas {
	private static final long serialVersionUID = 1;

	public void accept(IRDBVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.Schemas_ord;
	}

	public EntityDescriptor<Schemas> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Schemas;
	}
}
