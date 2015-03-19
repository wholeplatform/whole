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
public class IfStatementImpl extends AbstractSimpleEntity implements
		IfStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IfStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.IfStatement;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.IfStatement_ord;
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

	private Statement consequent;

	public Statement getConsequent() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.consequent,
				consequent);
	}

	public void setConsequent(Statement consequent) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.consequent,
				this.consequent, this.consequent = consequent);
	}

	private Statement alternate;

	public Statement getAlternate() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.alternate,
				alternate);
	}

	public void setAlternate(Statement alternate) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.alternate,
				this.alternate, this.alternate = alternate);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTest().wGetAdaptee(false);
		case 1:
			return getConsequent().wGetAdaptee(false);
		case 2:
			return getAlternate().wGetAdaptee(false);
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
			setConsequent(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Statement));
			break;
		case 2:
			setAlternate(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
