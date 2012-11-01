package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractUniqueListCompositeEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FromClausesStrictImpl extends
		AbstractUniqueListCompositeEntity<FromClause> implements FromClauses {
	private static final long serialVersionUID = 1;

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.FromClauses_ord;
	}

	public EntityDescriptor<FromClauses> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.FromClauses;
	}
}
