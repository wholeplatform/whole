package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SimpleTypeDefsAdapter extends
		AbstractListEntityAdapter<SimpleTypeDef> implements SimpleTypeDefs {
	private static final long serialVersionUID = 1;

	public SimpleTypeDefsAdapter(IEntity implementor) {
		super(implementor);
	}

	public SimpleTypeDefsAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SimpleTypeDefs> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.SimpleTypeDefs;
	}
}
