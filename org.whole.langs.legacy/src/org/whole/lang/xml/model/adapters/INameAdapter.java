package org.whole.lang.xml.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class INameAdapter extends AbstractEntityAdapter implements IName {
	private static final long serialVersionUID = 1;

	public INameAdapter(IEntity implementor) {
		super(implementor);
	}

	public INameAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IName> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.IName;
	}
}
