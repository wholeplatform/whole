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
public class SwitchStatementImpl extends AbstractSimpleEntity implements
		SwitchStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SwitchStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SwitchStatement;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.SwitchStatement_ord;
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

	private Statements statements;

	public Statements getStatements() {
		return notifyRequested(JavaFeatureDescriptorEnum.statements, statements);
	}

	public void setStatements(Statements statements) {
		notifyChanged(JavaFeatureDescriptorEnum.statements, this.statements,
				this.statements = statements);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getStatements().wGetAdaptee(false);
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
			setStatements(value
					.wGetAdapter(JavaEntityDescriptorEnum.Statements));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
