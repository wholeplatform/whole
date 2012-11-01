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
public class DocTypeDeclAdapter extends AbstractEntityAdapter implements
		DocTypeDecl {
	private static final long serialVersionUID = 1;

	public DocTypeDeclAdapter(IEntity implementor) {
		super(implementor);
	}

	public DocTypeDeclAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DocTypeDecl> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.DocTypeDecl;
	}

	public IName getName() {
		return wGet(XmlFeatureDescriptorEnum.name).wGetAdapter(
				XmlEntityDescriptorEnum.IName);
	}

	public void setName(IName name) {
		wSet(XmlFeatureDescriptorEnum.name, name);
	}

	public IExternalId getExternalId() {
		return wGet(XmlFeatureDescriptorEnum.externalId).wGetAdapter(
				XmlEntityDescriptorEnum.IExternalId);
	}

	public void setExternalId(IExternalId externalId) {
		wSet(XmlFeatureDescriptorEnum.externalId, externalId);
	}
}
