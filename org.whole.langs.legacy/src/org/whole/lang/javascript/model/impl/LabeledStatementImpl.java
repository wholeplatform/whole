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
public class LabeledStatementImpl extends AbstractSimpleEntity implements
		LabeledStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LabeledStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.LabeledStatement;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.LabeledStatement_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private Labels labels;

	public Labels getLabels() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.labels, labels);
	}

	public void setLabels(Labels labels) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.labels, this.labels,
				this.labels = labels);
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
			return getLabels().wGetAdaptee(false);
		case 1:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLabels(value.wGetAdapter(JavaScriptEntityDescriptorEnum.Labels));
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
