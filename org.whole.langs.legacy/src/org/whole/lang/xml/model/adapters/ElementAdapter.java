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
public class ElementAdapter extends AbstractEntityAdapter implements Element {
	private static final long serialVersionUID = 1;

	public ElementAdapter(IEntity implementor) {
		super(implementor);
	}

	public ElementAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Element> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.Element;
	}

	public IName getTag() {
		return wGet(XmlFeatureDescriptorEnum.tag).wGetAdapter(
				XmlEntityDescriptorEnum.IName);
	}

	public void setTag(IName tag) {
		wSet(XmlFeatureDescriptorEnum.tag, tag);
	}

	public Attributes getAttributes() {
		return wGet(XmlFeatureDescriptorEnum.attributes).wGetAdapter(
				XmlEntityDescriptorEnum.Attributes);
	}

	public void setAttributes(Attributes attributes) {
		wSet(XmlFeatureDescriptorEnum.attributes, attributes);
	}

	public IContent getContent() {
		return wGet(XmlFeatureDescriptorEnum.content).wGetAdapter(
				XmlEntityDescriptorEnum.IContent);
	}

	public void setContent(IContent content) {
		wSet(XmlFeatureDescriptorEnum.content, content);
	}
}
