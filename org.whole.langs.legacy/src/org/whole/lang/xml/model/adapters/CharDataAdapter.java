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
public class CharDataAdapter extends AbstractEntityAdapter implements CharData {
	private static final long serialVersionUID = 1;

	public CharDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public CharDataAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CharData> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.CharData;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
