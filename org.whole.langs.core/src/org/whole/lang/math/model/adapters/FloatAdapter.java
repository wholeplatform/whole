package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.math.model.Float;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FloatAdapter extends AbstractEntityAdapter implements Float {
	private static final long serialVersionUID = 1;

	public FloatAdapter(IEntity implementor) {
		super(implementor);
	}

	public FloatAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Float> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Float;
	}

	public float getValue() {
		return wFloatValue();
	}

	public void setValue(float value) {
		wSetValue(value);
	}
}
