package org.whole.lang.templates.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.templates.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.templates.reflect.TemplatesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class QualifiedNameImpl extends AbstractSimpleEntity implements
		QualifiedName {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<QualifiedName> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.QualifiedName;
	}

	public int wGetEntityOrd() {
		return TemplatesEntityDescriptorEnum.QualifiedName_ord;
	}

	public void accept(ITemplatesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getQualifier().wHashCode() + 29 * getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getQualifier().wEquals(
					entity.wGet(TemplatesFeatureDescriptorEnum.qualifier))
					&& getName().wEquals(
							entity.wGet(TemplatesFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("qualifier=");
		buffer.append(qualifier);
		buffer.append("name=");
		buffer.append(name);
	}

	private SimpleName qualifier;

	public SimpleName getQualifier() {
		return notifyRequested(TemplatesFeatureDescriptorEnum.qualifier,
				qualifier);
	}

	public void setQualifier(SimpleName qualifier) {
		notifyChanged(TemplatesFeatureDescriptorEnum.qualifier, this.qualifier,
				this.qualifier = qualifier);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(TemplatesFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(TemplatesFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getQualifier().wGetAdaptee(false);
		case 1:
			return getName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setQualifier(value
					.wGetAdapter(TemplatesEntityDescriptorEnum.SimpleName));
			break;
		case 1:
			setName(value.wGetAdapter(TemplatesEntityDescriptorEnum.Name));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
