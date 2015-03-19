package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ProcedureStatementsImpl extends
		AbstractCollectionCompositeEntity<SQLStatement> implements
		ProcedureStatements {
	private static final long serialVersionUID = 1;

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.ProcedureStatements_ord;
	}

	public EntityDescriptor<ProcedureStatements> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ProcedureStatements;
	}
}
