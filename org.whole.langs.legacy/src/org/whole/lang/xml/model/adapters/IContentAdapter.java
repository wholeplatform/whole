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
public class IContentAdapter extends AbstractEntityAdapter implements IContent {
	private static final long serialVersionUID = 1;

	public IContentAdapter(IEntity implementor) {
		super(implementor);
	}

	public IContentAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IContent> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.IContent;
	}
}
