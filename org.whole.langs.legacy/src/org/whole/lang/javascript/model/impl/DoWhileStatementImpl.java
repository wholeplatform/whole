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
public class DoWhileStatementImpl extends AbstractSimpleEntity implements
		DoWhileStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DoWhileStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.DoWhileStatement;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.DoWhileStatement_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private Statement body;

	public Statement getBody() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.body, body);
	}

	public void setBody(Statement body) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	private Expression test;

	public Expression getTest() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.test, test);
	}

	public void setTest(Expression test) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.test, this.test,
				this.test = test);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getBody().wGetAdaptee(false);
		case 1:
			return getTest().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setBody(value.wGetAdapter(JavaScriptEntityDescriptorEnum.Statement));
			break;
		case 1:
			setTest(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
