package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DoubleDataAdapter extends AbstractEntityAdapter implements
		DoubleData {
	private static final long serialVersionUID = 1;

	public DoubleDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public DoubleDataAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DoubleData> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.DoubleData;
	}

	public double getValue() {
		return wDoubleValue();
	}

	public void setValue(double value) {
		wSetValue(value);
	}
}
