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
public class IfStatementAdapter extends AbstractEntityAdapter implements
		IfStatement {
	private static final long serialVersionUID = 1;

	public IfStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public IfStatementAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IfStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.IfStatement;
	}

	public Expression getExpression() {
		return wGet(JavaFeatureDescriptorEnum.expression).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaFeatureDescriptorEnum.expression, expression);
	}

	public Statement getThenStatement() {
		return wGet(JavaFeatureDescriptorEnum.thenStatement).wGetAdapter(
				JavaEntityDescriptorEnum.Statement);
	}

	public void setThenStatement(Statement thenStatement) {
		wSet(JavaFeatureDescriptorEnum.thenStatement, thenStatement);
	}

	public Statement getElseStatement() {
		return wGet(JavaFeatureDescriptorEnum.elseStatement).wGetAdapter(
				JavaEntityDescriptorEnum.Statement);
	}

	public void setElseStatement(Statement elseStatement) {
		wSet(JavaFeatureDescriptorEnum.elseStatement, elseStatement);
	}
}
