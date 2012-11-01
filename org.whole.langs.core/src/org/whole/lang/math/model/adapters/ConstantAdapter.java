package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.model.ConstantEnum.Value;

/** 
 * @generator Whole
 */
public class ConstantAdapter extends AbstractEntityAdapter implements Constant {
	private static final long serialVersionUID = 1;

	public ConstantAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConstantAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Constant> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Constant;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
