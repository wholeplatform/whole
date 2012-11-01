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
public class ExponentiationAdapter extends AbstractEntityAdapter implements
		Exponentiation {
	private static final long serialVersionUID = 1;

	public ExponentiationAdapter(IEntity implementor) {
		super(implementor);
	}

	public ExponentiationAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Exponentiation> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Exponentiation;
	}

	public Expression getBase() {
		return wGet(MathFeatureDescriptorEnum.base).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setBase(Expression base) {
		wSet(MathFeatureDescriptorEnum.base, base);
	}

	public Expression getExponent() {
		return wGet(MathFeatureDescriptorEnum.exponent).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setExponent(Expression exponent) {
		wSet(MathFeatureDescriptorEnum.exponent, exponent);
	}
}
