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
public class PublicIdAdapter extends AbstractEntityAdapter implements PublicId {
	private static final long serialVersionUID = 1;

	public PublicIdAdapter(IEntity implementor) {
		super(implementor);
	}

	public PublicIdAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PublicId> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.PublicId;
	}

	public PubidLiteral getPubidLiteral() {
		return wGet(XmlFeatureDescriptorEnum.pubidLiteral).wGetAdapter(
				XmlEntityDescriptorEnum.PubidLiteral);
	}

	public void setPubidLiteral(PubidLiteral pubidLiteral) {
		wSet(XmlFeatureDescriptorEnum.pubidLiteral, pubidLiteral);
	}

	public SystemLiteral getSystemLiteral() {
		return wGet(XmlFeatureDescriptorEnum.systemLiteral).wGetAdapter(
				XmlEntityDescriptorEnum.SystemLiteral);
	}

	public void setSystemLiteral(SystemLiteral systemLiteral) {
		wSet(XmlFeatureDescriptorEnum.systemLiteral, systemLiteral);
	}
}
