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
public class RationalAdapter extends AbstractEntityAdapter implements Rational {
	private static final long serialVersionUID = 1;

	public RationalAdapter(IEntity implementor) {
		super(implementor);
	}

	public RationalAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Rational> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Rational;
	}

	public IntegerNumber getNumerator() {
		return wGet(MathFeatureDescriptorEnum.numerator).wGetAdapter(
				MathEntityDescriptorEnum.IntegerNumber);
	}

	public void setNumerator(IntegerNumber numerator) {
		wSet(MathFeatureDescriptorEnum.numerator, numerator);
	}

	public IntegerNumber getDenominator() {
		return wGet(MathFeatureDescriptorEnum.denominator).wGetAdapter(
				MathEntityDescriptorEnum.IntegerNumber);
	}

	public void setDenominator(IntegerNumber denominator) {
		wSet(MathFeatureDescriptorEnum.denominator, denominator);
	}
}
