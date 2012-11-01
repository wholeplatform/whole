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
public class AttributeAdapter extends AbstractEntityAdapter implements
		Attribute {
	private static final long serialVersionUID = 1;

	public AttributeAdapter(IEntity implementor) {
		super(implementor);
	}

	public AttributeAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Attribute> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.Attribute;
	}

	public IName getName() {
		return wGet(XmlFeatureDescriptorEnum.name).wGetAdapter(
				XmlEntityDescriptorEnum.IName);
	}

	public void setName(IName name) {
		wSet(XmlFeatureDescriptorEnum.name, name);
	}

	public Value getValue() {
		return wGet(XmlFeatureDescriptorEnum.value).wGetAdapter(
				XmlEntityDescriptorEnum.Value);
	}

	public void setValue(Value value) {
		wSet(XmlFeatureDescriptorEnum.value, value);
	}
}
