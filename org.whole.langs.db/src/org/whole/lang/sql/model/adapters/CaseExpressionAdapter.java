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
public class CaseExpressionAdapter extends AbstractEntityAdapter implements
		CaseExpression {
	private static final long serialVersionUID = 1;

	public CaseExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public CaseExpressionAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CaseExpression> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.CaseExpression;
	}

	public WhenClauses getWhenClauses() {
		return wGet(SQLFeatureDescriptorEnum.whenClauses).wGetAdapter(
				SQLEntityDescriptorEnum.WhenClauses);
	}

	public void setWhenClauses(WhenClauses whenClauses) {
		wSet(SQLFeatureDescriptorEnum.whenClauses, whenClauses);
	}

	public SQLExpression getElseClause() {
		return wGet(SQLFeatureDescriptorEnum.elseClause).wGetAdapter(
				SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setElseClause(SQLExpression elseClause) {
		wSet(SQLFeatureDescriptorEnum.elseClause, elseClause);
	}
}
