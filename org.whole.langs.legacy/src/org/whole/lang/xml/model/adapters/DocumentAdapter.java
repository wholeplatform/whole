package org.whole.lang.xml.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class DocumentAdapter extends AbstractEntityAdapter implements Document {
	private static final long serialVersionUID = 1;

	public DocumentAdapter(IEntity implementor) {
		super(implementor);
	}

	public DocumentAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Document> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.Document;
	}

	public Prolog getProlog() {
		return wGet(XmlFeatureDescriptorEnum.prolog).wGetAdapter(
				XmlEntityDescriptorEnum.Prolog);
	}

	public void setProlog(Prolog prolog) {
		wSet(XmlFeatureDescriptorEnum.prolog, prolog);
	}

	public Element getElement() {
		return wGet(XmlFeatureDescriptorEnum.element).wGetAdapter(
				XmlEntityDescriptorEnum.Element);
	}

	public void setElement(Element element) {
		wSet(XmlFeatureDescriptorEnum.element, element);
	}
}
