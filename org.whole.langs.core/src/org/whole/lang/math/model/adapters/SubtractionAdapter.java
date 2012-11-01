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
public class SubtractionAdapter extends AbstractEntityAdapter implements
		Subtraction {
	private static final long serialVersionUID = 1;

	public SubtractionAdapter(IEntity implementor) {
		super(implementor);
	}

	public SubtractionAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Subtraction> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Subtraction;
	}

	public Expression getMinuend() {
		return wGet(MathFeatureDescriptorEnum.minuend).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setMinuend(Expression minuend) {
		wSet(MathFeatureDescriptorEnum.minuend, minuend);
	}

	public Expression getSubtrahend() {
		return wGet(MathFeatureDescriptorEnum.subtrahend).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setSubtrahend(Expression subtrahend) {
		wSet(MathFeatureDescriptorEnum.subtrahend, subtrahend);
	}
}
