package org.whole.lang.flowchart.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.flowchart.visitors.IFlowchartVisitor;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class PixelsImpl extends AbstractDataEntity implements Pixels {
	private static final long serialVersionUID = 1;
	private int value;

	public int getValue() {
		return notifyRequested(value);
	}

	public void setValue(int value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IFlowchartVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FlowchartEntityDescriptorEnum.Pixels_ord;
	}

	public EntityDescriptor<Pixels> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.Pixels;
	}

	public Object wGetValue() {
		return new Integer(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Integer) value).intValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Integer.valueOf(value).intValue());
		} catch (NumberFormatException e) {
		}
	}

	public int wIntValue() {
		return getValue();
	}

	public void wSetValue(int value) {
		setValue(value);
	}
}
