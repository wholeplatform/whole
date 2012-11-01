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
public class SystemIdImpl extends AbstractSimpleEntity implements SystemId {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SystemId> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.SystemId;
	}

	public int wGetEntityOrd() {
		return XmlEntityDescriptorEnum.SystemId_ord;
	}

	public void accept(IXmlVisitor visitor) {
		visitor.visit(this);
	}

	private SystemLiteral systemLiteral;

	public SystemLiteral getSystemLiteral() {
		return notifyRequested(XmlFeatureDescriptorEnum.systemLiteral,
				systemLiteral);
	}

	public void setSystemLiteral(SystemLiteral systemLiteral) {
		notifyChanged(XmlFeatureDescriptorEnum.systemLiteral,
				this.systemLiteral, this.systemLiteral = systemLiteral);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSystemLiteral().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSystemLiteral(value
					.wGetAdapter(XmlEntityDescriptorEnum.SystemLiteral));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
