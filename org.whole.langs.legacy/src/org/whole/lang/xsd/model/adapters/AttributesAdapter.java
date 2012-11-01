package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractCollectionEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AttributesAdapter extends
		AbstractCollectionEntityAdapter<Attribute> implements Attributes {
	private static final long serialVersionUID = 1;

	public AttributesAdapter(IEntity implementor) {
		super(implementor);
	}

	public AttributesAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Attributes> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Attributes;
	}
}
