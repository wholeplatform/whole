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
public class XMLDeclAdapter extends AbstractEntityAdapter implements XMLDecl {
	private static final long serialVersionUID = 1;

	public XMLDeclAdapter(IEntity implementor) {
		super(implementor);
	}

	public XMLDeclAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<XMLDecl> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.XMLDecl;
	}

	public Version getVersion() {
		return wGet(XmlFeatureDescriptorEnum.version).wGetAdapter(
				XmlEntityDescriptorEnum.Version);
	}

	public void setVersion(Version version) {
		wSet(XmlFeatureDescriptorEnum.version, version);
	}

	public Encoding getEncoding() {
		return wGet(XmlFeatureDescriptorEnum.encoding).wGetAdapter(
				XmlEntityDescriptorEnum.Encoding);
	}

	public void setEncoding(Encoding encoding) {
		wSet(XmlFeatureDescriptorEnum.encoding, encoding);
	}

	public Standalone getStandalone() {
		return wGet(XmlFeatureDescriptorEnum.standalone).wGetAdapter(
				XmlEntityDescriptorEnum.Standalone);
	}

	public void setStandalone(Standalone standalone) {
		wSet(XmlFeatureDescriptorEnum.standalone, standalone);
	}
}
