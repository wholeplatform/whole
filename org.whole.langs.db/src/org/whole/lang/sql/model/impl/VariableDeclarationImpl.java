package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class VariableDeclarationImpl extends AbstractSimpleEntity implements
		VariableDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<VariableDeclaration> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.VariableDeclaration;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.VariableDeclaration_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Name name;

	public Name getName() {
		return notifyRequested(SQLFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(SQLFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Reference reference;

	public Reference getReference() {
		return notifyRequested(SQLFeatureDescriptorEnum.reference, reference);
	}

	public void setReference(Reference reference) {
		notifyChanged(SQLFeatureDescriptorEnum.reference, this.reference,
				this.reference = reference);
	}

	private ReferenceType referenceType;

	public ReferenceType getReferenceType() {
		return notifyRequested(SQLFeatureDescriptorEnum.referenceType,
				referenceType);
	}

	public void setReferenceType(ReferenceType referenceType) {
		notifyChanged(SQLFeatureDescriptorEnum.referenceType,
				this.referenceType, this.referenceType = referenceType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getReference().wGetAdaptee(false);
		case 2:
			return getReferenceType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(SQLEntityDescriptorEnum.Name));
			break;
		case 1:
			setReference(value.wGetAdapter(SQLEntityDescriptorEnum.Reference));
			break;
		case 2:
			setReferenceType(value
					.wGetAdapter(SQLEntityDescriptorEnum.ReferenceType));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
