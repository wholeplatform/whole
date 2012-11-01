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
public class QualifiedNameAdapter extends AbstractEntityAdapter implements
		QualifiedName {
	private static final long serialVersionUID = 1;

	public QualifiedNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public QualifiedNameAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<QualifiedName> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.QualifiedName;
	}

	public NameSpace getNameSpace() {
		return wGet(XmlFeatureDescriptorEnum.nameSpace).wGetAdapter(
				XmlEntityDescriptorEnum.NameSpace);
	}

	public void setNameSpace(NameSpace nameSpace) {
		wSet(XmlFeatureDescriptorEnum.nameSpace, nameSpace);
	}

	public Name getName() {
		return wGet(XmlFeatureDescriptorEnum.name).wGetAdapter(
				XmlEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(XmlFeatureDescriptorEnum.name, name);
	}
}
