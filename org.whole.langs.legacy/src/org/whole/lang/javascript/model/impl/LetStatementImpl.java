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
public class LetStatementImpl extends AbstractSimpleEntity implements
		LetStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LetStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.LetStatement;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.LetStatement_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private VariableInitializers variables;

	public VariableInitializers getVariables() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.variables,
				variables);
	}

	public void setVariables(VariableInitializers variables) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.variables,
				this.variables, this.variables = variables);
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
			return getVariables().wGetAdaptee(false);
		case 1:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setVariables(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.VariableInitializers));
			break;
		case 1:
			setBody(value.wGetAdapter(JavaScriptEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
