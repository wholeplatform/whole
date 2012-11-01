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
public class SetClauseAdapter extends AbstractEntityAdapter implements
		SetClause {
	private static final long serialVersionUID = 1;

	public SetClauseAdapter(IEntity implementor) {
		super(implementor);
	}

	public SetClauseAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SetClause> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.SetClause;
	}

	public ColumnName getColumnName() {
		return wGet(SQLFeatureDescriptorEnum.columnName).wGetAdapter(
				SQLEntityDescriptorEnum.ColumnName);
	}

	public void setColumnName(ColumnName columnName) {
		wSet(SQLFeatureDescriptorEnum.columnName, columnName);
	}

	public SQLExpression getExpression() {
		return wGet(SQLFeatureDescriptorEnum.expression).wGetAdapter(
				SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setExpression(SQLExpression expression) {
		wSet(SQLFeatureDescriptorEnum.expression, expression);
	}
}
