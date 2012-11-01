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
public class DocumentImpl extends AbstractSimpleEntity implements Document {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Document> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.Document;
	}

	public int wGetEntityOrd() {
		return XmlEntityDescriptorEnum.Document_ord;
	}

	public void accept(IXmlVisitor visitor) {
		visitor.visit(this);
	}

	private Prolog prolog;

	public Prolog getProlog() {
		return notifyRequested(XmlFeatureDescriptorEnum.prolog, prolog);
	}

	public void setProlog(Prolog prolog) {
		notifyChanged(XmlFeatureDescriptorEnum.prolog, this.prolog,
				this.prolog = prolog);
	}

	private Element element;

	public Element getElement() {
		return notifyRequested(XmlFeatureDescriptorEnum.element, element);
	}

	public void setElement(Element element) {
		notifyChanged(XmlFeatureDescriptorEnum.element, this.element,
				this.element = element);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getProlog().wGetAdaptee(false);
		case 1:
			return getElement().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setProlog(value.wGetAdapter(XmlEntityDescriptorEnum.Prolog));
			break;
		case 1:
			setElement(value.wGetAdapter(XmlEntityDescriptorEnum.Element));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
