package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class IfStatementImpl extends AbstractSimpleEntity implements
		IfStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IfStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.IfStatement;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.IfStatement_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(JavaFeatureDescriptorEnum.expression, expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(JavaFeatureDescriptorEnum.expression, this.expression,
				this.expression = expression);
	}

	private Statement thenStatement;

	public Statement getThenStatement() {
		return notifyRequested(JavaFeatureDescriptorEnum.thenStatement,
				thenStatement);
	}

	public void setThenStatement(Statement thenStatement) {
		notifyChanged(JavaFeatureDescriptorEnum.thenStatement,
				this.thenStatement, this.thenStatement = thenStatement);
	}

	private Statement elseStatement;

	public Statement getElseStatement() {
		return notifyRequested(JavaFeatureDescriptorEnum.elseStatement,
				elseStatement);
	}

	public void setElseStatement(Statement elseStatement) {
		notifyChanged(JavaFeatureDescriptorEnum.elseStatement,
				this.elseStatement, this.elseStatement = elseStatement);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getThenStatement().wGetAdaptee(false);
		case 2:
			return getElseStatement().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpression(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		case 1:
			setThenStatement(value
					.wGetAdapter(JavaEntityDescriptorEnum.Statement));
			break;
		case 2:
			setElseStatement(value
					.wGetAdapter(JavaEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
