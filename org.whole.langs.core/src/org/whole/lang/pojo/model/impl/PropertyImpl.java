package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PropertyImpl extends AbstractSimpleEntity implements Property {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Property> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Property;
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.Property_ord;
	}

	public void accept(IPojoVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Annotations annotations;

	public Annotations getAnnotations() {
		return notifyRequested(PojoFeatureDescriptorEnum.annotations,
				annotations);
	}

	public void setAnnotations(Annotations annotations) {
		notifyChanged(PojoFeatureDescriptorEnum.annotations, this.annotations,
				this.annotations = annotations);
	}

	private Type type;

	public Type getType() {
		return notifyRequested(PojoFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(PojoFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	public int wHashCode() {
		return getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName().wEquals(
					entity.wGet(PojoFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(PojoFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(PojoFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Name template;

	public Name getTemplate() {
		return notifyRequested(PojoFeatureDescriptorEnum.template, template);
	}

	public void setTemplate(Name template) {
		notifyChanged(PojoFeatureDescriptorEnum.template, this.template,
				this.template = template);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getAnnotations().wGetAdaptee(false);
		case 1:
			return getType().wGetAdaptee(false);
		case 2:
			return getName().wGetAdaptee(false);
		case 3:
			return getTemplate().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setAnnotations(value
					.wGetAdapter(PojoEntityDescriptorEnum.Annotations));
			break;
		case 1:
			setType(value.wGetAdapter(PojoEntityDescriptorEnum.Type));
			break;
		case 2:
			setName(value.wGetAdapter(PojoEntityDescriptorEnum.Name));
			break;
		case 3:
			setTemplate(value.wGetAdapter(PojoEntityDescriptorEnum.Name));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
