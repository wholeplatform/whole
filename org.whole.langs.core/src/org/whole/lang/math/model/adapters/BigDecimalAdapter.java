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
public class BigDecimalAdapter extends AbstractEntityAdapter implements
		BigDecimal {
	private static final long serialVersionUID = 1;

	public BigDecimalAdapter(IEntity implementor) {
		super(implementor);
	}

	public BigDecimalAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BigDecimal> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.BigDecimal;
	}

	public java.math.BigDecimal getValue() {
		return (java.math.BigDecimal) wGetValue();
	}

	public void setValue(java.math.BigDecimal value) {
		wSetValue((Object) value);
	}
}
