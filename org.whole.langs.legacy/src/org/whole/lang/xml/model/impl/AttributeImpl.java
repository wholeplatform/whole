package org.whole.lang.xml.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xml.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class AttributeImpl extends AbstractSimpleEntity implements Attribute {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Attribute> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.Attribute;
	}

	public int wGetEntityOrd() {
		return XmlEntityDescriptorEnum.Attribute_ord;
	}

	public void accept(IXmlVisitor visitor) {
		visitor.visit(this);
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
			return getName()
					.wEquals(entity.wGet(XmlFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private IName name;

	public IName getName() {
		return notifyRequested(XmlFeatureDescriptorEnum.name, name);
	}

	public void setName(IName name) {
		notifyChanged(XmlFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Value value;

	public Value getValue() {
		return notifyRequested(XmlFeatureDescriptorEnum.value, value);
	}

	public void setValue(Value value) {
		notifyChanged(XmlFeatureDescriptorEnum.value, this.value,
				this.value = value);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getValue().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(XmlEntityDescriptorEnum.IName));
			break;
		case 1:
			setValue(value.wGetAdapter(XmlEntityDescriptorEnum.Value));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
