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
public class SystemIdAdapter extends AbstractEntityAdapter implements SystemId {
	private static final long serialVersionUID = 1;

	public SystemIdAdapter(IEntity implementor) {
		super(implementor);
	}

	public SystemIdAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SystemId> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.SystemId;
	}

	public SystemLiteral getSystemLiteral() {
		return wGet(XmlFeatureDescriptorEnum.systemLiteral).wGetAdapter(
				XmlEntityDescriptorEnum.SystemLiteral);
	}

	public void setSystemLiteral(SystemLiteral systemLiteral) {
		wSet(XmlFeatureDescriptorEnum.systemLiteral, systemLiteral);
	}
}
