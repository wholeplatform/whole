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
public class WhenClauseAdapter extends AbstractEntityAdapter implements WhenClause {
	private static final long serialVersionUID = 1;

	public WhenClauseAdapter(IEntity implementor) {
		super(implementor);
	}

	public WhenClauseAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<WhenClause> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.WhenClause;
	}

	public BooleanExpression getCondition() {
		return wGet(SQLFeatureDescriptorEnum.condition).wGetAdapter(SQLEntityDescriptorEnum.BooleanExpression);
	}

	public void setCondition(BooleanExpression condition) {
		wSet(SQLFeatureDescriptorEnum.condition, condition);
	}

	public SQLExpression getResult() {
		return wGet(SQLFeatureDescriptorEnum.result).wGetAdapter(SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setResult(SQLExpression result) {
		wSet(SQLFeatureDescriptorEnum.result, result);
	}
}
