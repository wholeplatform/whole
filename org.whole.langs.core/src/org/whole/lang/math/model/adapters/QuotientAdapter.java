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
public class QuotientAdapter extends AbstractEntityAdapter implements Quotient {
	private static final long serialVersionUID = 1;

	public QuotientAdapter(IEntity implementor) {
		super(implementor);
	}

	public QuotientAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Quotient> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Quotient;
	}

	public Expression getDividend() {
		return wGet(MathFeatureDescriptorEnum.dividend).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setDividend(Expression dividend) {
		wSet(MathFeatureDescriptorEnum.dividend, dividend);
	}

	public Expression getDivisor() {
		return wGet(MathFeatureDescriptorEnum.divisor).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setDivisor(Expression divisor) {
		wSet(MathFeatureDescriptorEnum.divisor, divisor);
	}
}
