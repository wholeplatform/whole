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
public class PublicIdImpl extends AbstractSimpleEntity implements PublicId {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PublicId> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.PublicId;
	}

	public int wGetEntityOrd() {
		return XmlEntityDescriptorEnum.PublicId_ord;
	}

	public void accept(IXmlVisitor visitor) {
		visitor.visit(this);
	}

	private PubidLiteral pubidLiteral;

	public PubidLiteral getPubidLiteral() {
		return notifyRequested(XmlFeatureDescriptorEnum.pubidLiteral,
				pubidLiteral);
	}

	public void setPubidLiteral(PubidLiteral pubidLiteral) {
		notifyChanged(XmlFeatureDescriptorEnum.pubidLiteral, this.pubidLiteral,
				this.pubidLiteral = pubidLiteral);
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
			return getPubidLiteral().wGetAdaptee(false);
		case 1:
			return getSystemLiteral().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPubidLiteral(value
					.wGetAdapter(XmlEntityDescriptorEnum.PubidLiteral));
			break;
		case 1:
			setSystemLiteral(value
					.wGetAdapter(XmlEntityDescriptorEnum.SystemLiteral));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
