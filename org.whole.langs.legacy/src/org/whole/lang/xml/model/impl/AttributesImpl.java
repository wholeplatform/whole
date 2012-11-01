package org.whole.lang.xml.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.xml.model.*;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class AttributesImpl extends
		AbstractCollectionCompositeEntity<Attribute> implements Attributes {
	private static final long serialVersionUID = 1;

	public void accept(IXmlVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XmlEntityDescriptorEnum.Attributes_ord;
	}

	public EntityDescriptor<Attributes> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.Attributes;
	}
}
