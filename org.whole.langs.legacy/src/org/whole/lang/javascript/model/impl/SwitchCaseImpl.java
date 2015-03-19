package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SwitchCaseImpl extends AbstractSimpleEntity implements SwitchCase {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SwitchCase> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.SwitchCase;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.SwitchCase_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Expression test;

	public Expression getTest() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.test, test);
	}

	public void setTest(Expression test) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.test, this.test,
				this.test = test);
	}

	private Statements statements;

	public Statements getStatements() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.statements,
				statements);
	}

	public void setStatements(Statements statements) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.statements,
				this.statements, this.statements = statements);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTest().wGetAdaptee(false);
		case 1:
			return getStatements().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTest(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 1:
			setStatements(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Statements));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
