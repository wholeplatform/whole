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
public class FloatDataAdapter extends AbstractEntityAdapter implements
		FloatData {
	private static final long serialVersionUID = 1;

	public FloatDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public FloatDataAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FloatData> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.FloatData;
	}

	public float getValue() {
		return wFloatValue();
	}

	public void setValue(float value) {
		wSetValue(value);
	}
}
