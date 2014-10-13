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
public class CatchClauseImpl extends AbstractSimpleEntity implements
		CatchClause {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CatchClause> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.CatchClause;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.CatchClause_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private SingleVariableDeclaration exception;

	public SingleVariableDeclaration getException() {
		return notifyRequested(JavaFeatureDescriptorEnum.exception, exception);
	}

	public void setException(SingleVariableDeclaration exception) {
		notifyChanged(JavaFeatureDescriptorEnum.exception, this.exception,
				this.exception = exception);
	}

	private Block body;

	public Block getBody() {
		return notifyRequested(JavaFeatureDescriptorEnum.body, body);
	}

	public void setBody(Block body) {
		notifyChanged(JavaFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getException().wGetAdaptee(false);
		case 1:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setException(value
					.wGetAdapter(JavaEntityDescriptorEnum.SingleVariableDeclaration));
			break;
		case 1:
			setBody(value.wGetAdapter(JavaEntityDescriptorEnum.Block));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
