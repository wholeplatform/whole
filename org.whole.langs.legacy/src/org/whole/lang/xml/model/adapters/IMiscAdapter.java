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
public class IMiscAdapter extends AbstractEntityAdapter implements IMisc {
	private static final long serialVersionUID = 1;

	public IMiscAdapter(IEntity implementor) {
		super(implementor);
	}

	public IMiscAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IMisc> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.IMisc;
	}
}
