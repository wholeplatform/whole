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
public class ColumnExpressionAdapter extends AbstractEntityAdapter implements
		ColumnExpression {
	private static final long serialVersionUID = 1;

	public ColumnExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ColumnExpressionAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ColumnExpression> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ColumnExpression;
	}

	public SQLExpression getExpression() {
		return wGet(SQLFeatureDescriptorEnum.expression).wGetAdapter(
				SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setExpression(SQLExpression expression) {
		wSet(SQLFeatureDescriptorEnum.expression, expression);
	}

	public Alias getAlias() {
		return wGet(SQLFeatureDescriptorEnum.alias).wGetAdapter(
				SQLEntityDescriptorEnum.Alias);
	}

	public void setAlias(Alias alias) {
		wSet(SQLFeatureDescriptorEnum.alias, alias);
	}
}
