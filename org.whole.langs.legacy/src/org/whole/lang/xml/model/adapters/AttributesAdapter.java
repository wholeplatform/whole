package org.whole.lang.xml.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AttributesAdapter extends AbstractListEntityAdapter<Attribute>
		implements Attributes {
	private static final long serialVersionUID = 1;

	public AttributesAdapter(IEntity implementor) {
		super(implementor);
	}

	public AttributesAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Attributes> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.Attributes;
	}
}
