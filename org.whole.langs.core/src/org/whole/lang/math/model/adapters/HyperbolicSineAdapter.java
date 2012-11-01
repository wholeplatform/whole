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
public class HyperbolicSineAdapter extends AbstractEntityAdapter implements
		HyperbolicSine {
	private static final long serialVersionUID = 1;

	public HyperbolicSineAdapter(IEntity implementor) {
		super(implementor);
	}

	public HyperbolicSineAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<HyperbolicSine> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.HyperbolicSine;
	}

	public Expression getExpression() {
		return wGet(MathFeatureDescriptorEnum.expression).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(MathFeatureDescriptorEnum.expression, expression);
	}
}
