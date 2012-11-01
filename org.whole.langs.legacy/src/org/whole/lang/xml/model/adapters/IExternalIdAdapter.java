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
public class IExternalIdAdapter extends AbstractEntityAdapter implements
		IExternalId {
	private static final long serialVersionUID = 1;

	public IExternalIdAdapter(IEntity implementor) {
		super(implementor);
	}

	public IExternalIdAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IExternalId> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.IExternalId;
	}
}
