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
public class PubidLiteralAdapter extends AbstractEntityAdapter implements
		PubidLiteral {
	private static final long serialVersionUID = 1;

	public PubidLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public PubidLiteralAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PubidLiteral> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.PubidLiteral;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
