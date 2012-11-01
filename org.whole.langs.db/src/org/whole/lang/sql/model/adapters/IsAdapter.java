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
public class IsAdapter extends AbstractEntityAdapter implements Is {
	private static final long serialVersionUID = 1;

	public IsAdapter(IEntity implementor) {
		super(implementor);
	}

	public IsAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Is> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Is;
	}

	public SQLExpression getExpression() {
		return wGet(SQLFeatureDescriptorEnum.expression).wGetAdapter(
				SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setExpression(SQLExpression expression) {
		wSet(SQLFeatureDescriptorEnum.expression, expression);
	}

	public IsType getType() {
		return wGet(SQLFeatureDescriptorEnum.type).wGetAdapter(
				SQLEntityDescriptorEnum.IsType);
	}

	public void setType(IsType type) {
		wSet(SQLFeatureDescriptorEnum.type, type);
	}
}
