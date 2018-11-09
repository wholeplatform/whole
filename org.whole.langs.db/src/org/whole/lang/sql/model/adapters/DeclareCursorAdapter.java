package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class DeclareCursorAdapter extends AbstractEntityAdapter implements DeclareCursor {
	private static final long serialVersionUID = 1;

	public DeclareCursorAdapter(IEntity implementor) {
		super(implementor);
	}

	public DeclareCursorAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DeclareCursor> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.DeclareCursor;
	}

	public Name getName() {
		return wGet(SQLFeatureDescriptorEnum.name).wGetAdapter(SQLEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(SQLFeatureDescriptorEnum.name, name);
	}

	public SQLStatement getSqlStatement() {
		return wGet(SQLFeatureDescriptorEnum.sqlStatement).wGetAdapter(SQLEntityDescriptorEnum.SQLStatement);
	}

	public void setSqlStatement(SQLStatement sqlStatement) {
		wSet(SQLFeatureDescriptorEnum.sqlStatement, sqlStatement);
	}
}
