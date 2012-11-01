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
public class LogarithmAdapter extends AbstractEntityAdapter implements
		Logarithm {
	private static final long serialVersionUID = 1;

	public LogarithmAdapter(IEntity implementor) {
		super(implementor);
	}

	public LogarithmAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Logarithm> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Logarithm;
	}

	public Expression getExpression() {
		return wGet(MathFeatureDescriptorEnum.expression).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(MathFeatureDescriptorEnum.expression, expression);
	}

	public Expression getBase() {
		return wGet(MathFeatureDescriptorEnum.base).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setBase(Expression base) {
		wSet(MathFeatureDescriptorEnum.base, base);
	}
}
