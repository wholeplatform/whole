package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ShortIntegerAdapter extends AbstractEntityAdapter implements
		ShortInteger {
	private static final long serialVersionUID = 1;

	public ShortIntegerAdapter(IEntity implementor) {
		super(implementor);
	}

	public ShortIntegerAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ShortInteger> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.ShortInteger;
	}

	public short getValue() {
		return wShortValue();
	}

	public void setValue(short value) {
		wSetValue(value);
	}
}
