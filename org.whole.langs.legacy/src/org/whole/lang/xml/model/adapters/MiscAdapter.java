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
public class MiscAdapter extends AbstractListEntityAdapter<IMisc> implements
		Misc {
	private static final long serialVersionUID = 1;

	public MiscAdapter(IEntity implementor) {
		super(implementor);
	}

	public MiscAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Misc> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.Misc;
	}
}
