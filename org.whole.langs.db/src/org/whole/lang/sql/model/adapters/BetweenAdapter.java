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
public class BetweenAdapter extends AbstractEntityAdapter implements Between {
	private static final long serialVersionUID = 1;

	public BetweenAdapter(IEntity implementor) {
		super(implementor);
	}

	public BetweenAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Between> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Between;
	}

	public SQLExpression getExpression() {
		return wGet(SQLFeatureDescriptorEnum.expression).wGetAdapter(SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setExpression(SQLExpression expression) {
		wSet(SQLFeatureDescriptorEnum.expression, expression);
	}

	public SQLExpression getLowerExpression() {
		return wGet(SQLFeatureDescriptorEnum.lowerExpression).wGetAdapter(SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setLowerExpression(SQLExpression lowerExpression) {
		wSet(SQLFeatureDescriptorEnum.lowerExpression, lowerExpression);
	}

	public SQLExpression getUpperExpression() {
		return wGet(SQLFeatureDescriptorEnum.upperExpression).wGetAdapter(SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setUpperExpression(SQLExpression upperExpression) {
		wSet(SQLFeatureDescriptorEnum.upperExpression, upperExpression);
	}
}
