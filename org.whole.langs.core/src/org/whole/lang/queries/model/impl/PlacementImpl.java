package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class PlacementImpl extends AbstractDataEntity implements Placement {
	private static final long serialVersionUID = 1;
	private org.whole.lang.queries.model.PlacementEnum.Value value;

	public org.whole.lang.queries.model.PlacementEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.queries.model.PlacementEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.Placement_ord;
	}

	public EntityDescriptor<Placement> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.Placement;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.queries.model.PlacementEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(PlacementEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.queries.model.PlacementEnum.Value) value);
	}
}
