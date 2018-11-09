package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SelectSQLStatementAdapter extends AbstractEntityAdapter implements SelectSQLStatement {
	private static final long serialVersionUID = 1;

	public SelectSQLStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public SelectSQLStatementAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SelectSQLStatement> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.SelectSQLStatement;
	}
}
