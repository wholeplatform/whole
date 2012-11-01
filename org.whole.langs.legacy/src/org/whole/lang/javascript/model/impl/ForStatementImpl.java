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
public class ForStatementImpl extends AbstractSimpleEntity implements
		ForStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ForStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ForStatement;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.ForStatement_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private VariableDeclarationOrExpression init;

	public VariableDeclarationOrExpression getInit() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.init, init);
	}

	public void setInit(VariableDeclarationOrExpression init) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.init, this.init,
				this.init = init);
	}

	private Expression test;

	public Expression getTest() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.test, test);
	}

	public void setTest(Expression test) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.test, this.test,
				this.test = test);
	}

	private Expression update;

	public Expression getUpdate() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.update, update);
	}

	public void setUpdate(Expression update) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.update, this.update,
				this.update = update);
	}

	private Statement body;

	public Statement getBody() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.body, body);
	}

	public void setBody(Statement body) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getInit().wGetAdaptee(false);
		case 1:
			return getTest().wGetAdaptee(false);
		case 2:
			return getUpdate().wGetAdaptee(false);
		case 3:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setInit(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.VariableDeclarationOrExpression));
			break;
		case 1:
			setTest(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 2:
			setUpdate(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 3:
			setBody(value.wGetAdapter(JavaScriptEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
