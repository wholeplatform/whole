package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.AddAction;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.DeclarationOrConstraint;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class AddActionImpl extends AbstractSimpleEntity implements AddAction {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AddAction> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.AddAction;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.AddAction_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private DeclarationOrConstraint declarationOrConstraint;

	public DeclarationOrConstraint getDeclarationOrConstraint() {
		return notifyRequested(SQLFeatureDescriptorEnum.declarationOrConstraint, declarationOrConstraint);
	}

	public void setDeclarationOrConstraint(DeclarationOrConstraint declarationOrConstraint) {
		notifyChanged(SQLFeatureDescriptorEnum.declarationOrConstraint, this.declarationOrConstraint,
				this.declarationOrConstraint = declarationOrConstraint);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDeclarationOrConstraint().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setDeclarationOrConstraint(value.wGetAdapter(SQLEntityDescriptorEnum.DeclarationOrConstraint));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
