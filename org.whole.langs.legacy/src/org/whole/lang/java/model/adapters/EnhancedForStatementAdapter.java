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
public class EnhancedForStatementAdapter extends AbstractEntityAdapter
		implements EnhancedForStatement {
	private static final long serialVersionUID = 1;

	public EnhancedForStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public EnhancedForStatementAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EnhancedForStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.EnhancedForStatement;
	}

	public SingleVariableDeclaration getParameter() {
		return wGet(JavaFeatureDescriptorEnum.parameter).wGetAdapter(
				JavaEntityDescriptorEnum.SingleVariableDeclaration);
	}

	public void setParameter(SingleVariableDeclaration parameter) {
		wSet(JavaFeatureDescriptorEnum.parameter, parameter);
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
