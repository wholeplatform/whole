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
public class PrologImpl extends AbstractSimpleEntity implements Prolog {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Prolog> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.Prolog;
	}

	public int wGetEntityOrd() {
		return XmlEntityDescriptorEnum.Prolog_ord;
	}

	public void accept(IXmlVisitor visitor) {
		visitor.visit(this);
	}

	private XMLDecl xmlDecl;

	public XMLDecl getXmlDecl() {
		return notifyRequested(XmlFeatureDescriptorEnum.xmlDecl, xmlDecl);
	}

	public void setXmlDecl(XMLDecl xmlDecl) {
		notifyChanged(XmlFeatureDescriptorEnum.xmlDecl, this.xmlDecl,
				this.xmlDecl = xmlDecl);
	}

	private DocTypeDecl docTypeDecl;

	public DocTypeDecl getDocTypeDecl() {
		return notifyRequested(XmlFeatureDescriptorEnum.docTypeDecl,
				docTypeDecl);
	}

	public void setDocTypeDecl(DocTypeDecl docTypeDecl) {
		notifyChanged(XmlFeatureDescriptorEnum.docTypeDecl, this.docTypeDecl,
				this.docTypeDecl = docTypeDecl);
	}

	private Misc misc;

	public Misc getMisc() {
		return notifyRequested(XmlFeatureDescriptorEnum.misc, misc);
	}

	public void setMisc(Misc misc) {
		notifyChanged(XmlFeatureDescriptorEnum.misc, this.misc,
				this.misc = misc);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getXmlDecl().wGetAdaptee(false);
		case 1:
			return getDocTypeDecl().wGetAdaptee(false);
		case 2:
			return getMisc().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setXmlDecl(value.wGetAdapter(XmlEntityDescriptorEnum.XMLDecl));
			break;
		case 1:
			setDocTypeDecl(value
					.wGetAdapter(XmlEntityDescriptorEnum.DocTypeDecl));
			break;
		case 2:
			setMisc(value.wGetAdapter(XmlEntityDescriptorEnum.Misc));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
