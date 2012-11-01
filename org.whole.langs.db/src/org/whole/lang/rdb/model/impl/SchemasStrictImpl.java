package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SchemasStrictImpl extends AbstractSetCompositeEntity<Schema>
		implements Schemas {
	private static final long serialVersionUID = 1;

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.Schemas_ord;
	}

	public EntityDescriptor<Schemas> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Schemas;
	}
}
