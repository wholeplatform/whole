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
public class TryStatementImpl extends AbstractSimpleEntity implements
		TryStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TryStatement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.TryStatement;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.TryStatement_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Block body;

	public Block getBody() {
		return notifyRequested(JavaFeatureDescriptorEnum.body, body);
	}

	public void setBody(Block body) {
		notifyChanged(JavaFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	private CatchClauses catchClauses;

	public CatchClauses getCatchClauses() {
		return notifyRequested(JavaFeatureDescriptorEnum.catchClauses,
				catchClauses);
	}

	public void setCatchClauses(CatchClauses catchClauses) {
		notifyChanged(JavaFeatureDescriptorEnum.catchClauses,
				this.catchClauses, this.catchClauses = catchClauses);
	}

	private Block _finally;

	public Block getFinally() {
		return notifyRequested(JavaFeatureDescriptorEnum._finally, _finally);
	}

	public void setFinally(Block _finally) {
		notifyChanged(JavaFeatureDescriptorEnum._finally, this._finally,
				this._finally = _finally);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getBody().wGetAdaptee(false);
		case 1:
			return getCatchClauses().wGetAdaptee(false);
		case 2:
			return getFinally().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setBody(value.wGetAdapter(JavaEntityDescriptorEnum.Block));
			break;
		case 1:
			setCatchClauses(value
					.wGetAdapter(JavaEntityDescriptorEnum.CatchClauses));
			break;
		case 2:
			setFinally(value.wGetAdapter(JavaEntityDescriptorEnum.Block));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
