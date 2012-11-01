package org.whole.lang.xml.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.xml.model.*;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class CDataSectDataImpl extends AbstractDataEntity implements
		CDataSectData {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IXmlVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XmlEntityDescriptorEnum.CDataSectData_ord;
	}

	public EntityDescriptor<CDataSectData> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.CDataSectData;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((String) value);
	}

	public String wStringValue() {
		return getValue();
	}

	public void wSetValue(String value) {
		setValue(value);
	}
}
