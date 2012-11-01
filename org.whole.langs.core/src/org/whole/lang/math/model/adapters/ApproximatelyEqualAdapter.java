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
public class ApproximatelyEqualAdapter extends AbstractEntityAdapter implements
		ApproximatelyEqual {
	private static final long serialVersionUID = 1;

	public ApproximatelyEqualAdapter(IEntity implementor) {
		super(implementor);
	}

	public ApproximatelyEqualAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ApproximatelyEqual> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.ApproximatelyEqual;
	}

	public Expression getExp1() {
		return wGet(MathFeatureDescriptorEnum.exp1).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setExp1(Expression exp1) {
		wSet(MathFeatureDescriptorEnum.exp1, exp1);
	}

	public Expression getExp2() {
		return wGet(MathFeatureDescriptorEnum.exp2).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setExp2(Expression exp2) {
		wSet(MathFeatureDescriptorEnum.exp2, exp2);
	}
}
