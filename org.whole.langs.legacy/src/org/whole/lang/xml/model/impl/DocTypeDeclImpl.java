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
public class DocTypeDeclImpl extends AbstractSimpleEntity implements
		DocTypeDecl {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DocTypeDecl> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.DocTypeDecl;
	}

	public int wGetEntityOrd() {
		return XmlEntityDescriptorEnum.DocTypeDecl_ord;
	}

	public void accept(IXmlVisitor visitor) {
		visitor.visit(this);
	}

	private IName name;

	public IName getName() {
		return notifyRequested(XmlFeatureDescriptorEnum.name, name);
	}

	public void setName(IName name) {
		notifyChanged(XmlFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private IExternalId externalId;

	public IExternalId getExternalId() {
		return notifyRequested(XmlFeatureDescriptorEnum.externalId, externalId);
	}

	public void setExternalId(IExternalId externalId) {
		notifyChanged(XmlFeatureDescriptorEnum.externalId, this.externalId,
				this.externalId = externalId);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getExternalId().wGetAdaptee(false);
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
			setExternalId(value
					.wGetAdapter(XmlEntityDescriptorEnum.IExternalId));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
