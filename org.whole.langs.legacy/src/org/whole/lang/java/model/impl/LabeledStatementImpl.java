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
public class LabeledStatementImpl extends AbstractSimpleEntity implements
		LabeledStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LabeledStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.LabeledStatement;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.LabeledStatement_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private SimpleName label;

	public SimpleName getLabel() {
		return notifyRequested(JavaFeatureDescriptorEnum.label, label);
	}

	public void setLabel(SimpleName label) {
		notifyChanged(JavaFeatureDescriptorEnum.label, this.label,
				this.label = label);
	}

	private Statement body;

	public Statement getBody() {
		return notifyRequested(JavaFeatureDescriptorEnum.body, body);
	}

	public void setBody(Statement body) {
		notifyChanged(JavaFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLabel(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
			break;
		case 1:
			setBody(value.wGetAdapter(JavaEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
