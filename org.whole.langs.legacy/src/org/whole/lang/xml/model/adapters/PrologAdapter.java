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
public class PrologAdapter extends AbstractEntityAdapter implements Prolog {
	private static final long serialVersionUID = 1;

	public PrologAdapter(IEntity implementor) {
		super(implementor);
	}

	public PrologAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Prolog> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.Prolog;
	}

	public XMLDecl getXmlDecl() {
		return wGet(XmlFeatureDescriptorEnum.xmlDecl).wGetAdapter(
				XmlEntityDescriptorEnum.XMLDecl);
	}

	public void setXmlDecl(XMLDecl xmlDecl) {
		wSet(XmlFeatureDescriptorEnum.xmlDecl, xmlDecl);
	}

	public DocTypeDecl getDocTypeDecl() {
		return wGet(XmlFeatureDescriptorEnum.docTypeDecl).wGetAdapter(
				XmlEntityDescriptorEnum.DocTypeDecl);
	}

	public void setDocTypeDecl(DocTypeDecl docTypeDecl) {
		wSet(XmlFeatureDescriptorEnum.docTypeDecl, docTypeDecl);
	}

	public Misc getMisc() {
		return wGet(XmlFeatureDescriptorEnum.misc).wGetAdapter(
				XmlEntityDescriptorEnum.Misc);
	}

	public void setMisc(Misc misc) {
		wSet(XmlFeatureDescriptorEnum.misc, misc);
	}
}
