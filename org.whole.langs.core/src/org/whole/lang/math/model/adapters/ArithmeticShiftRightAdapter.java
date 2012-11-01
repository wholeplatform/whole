package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ArithmeticShiftRightAdapter extends AbstractEntityAdapter
		implements ArithmeticShiftRight {
	private static final long serialVersionUID = 1;

	public ArithmeticShiftRightAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArithmeticShiftRightAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArithmeticShiftRight> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.ArithmeticShiftRight;
	}

	public Expression getExpression() {
		return wGet(MathFeatureDescriptorEnum.expression).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(MathFeatureDescriptorEnum.expression, expression);
	}

	public Expression getBits() {
		return wGet(MathFeatureDescriptorEnum.bits).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setBits(Expression bits) {
		wSet(MathFeatureDescriptorEnum.bits, bits);
	}
}
