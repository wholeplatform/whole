package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class WhileStatementAdapter extends AbstractEntityAdapter implements
		WhileStatement {
	private static final long serialVersionUID = 1;

	public WhileStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public WhileStatementAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<WhileStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.WhileStatement;
	}

	public Expression getExpression() {
		return wGet(JavaFeatureDescriptorEnum.expression).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaFeatureDescriptorEnum.expression, expression);
	}

	public Statement getBody() {
		return wGet(JavaFeatureDescriptorEnum.body).wGetAdapter(
				JavaEntityDescriptorEnum.Statement);
	}

	public void setBody(Statement body) {
		wSet(JavaFeatureDescriptorEnum.body, body);
	}
}
