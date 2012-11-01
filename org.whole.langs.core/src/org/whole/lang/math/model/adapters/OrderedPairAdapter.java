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
public class OrderedPairAdapter extends AbstractEntityAdapter implements
		OrderedPair {
	private static final long serialVersionUID = 1;

	public OrderedPairAdapter(IEntity implementor) {
		super(implementor);
	}

	public OrderedPairAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<OrderedPair> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.OrderedPair;
	}

	public Expression getFirst() {
		return wGet(MathFeatureDescriptorEnum.first).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setFirst(Expression first) {
		wSet(MathFeatureDescriptorEnum.first, first);
	}

	public Expression getSecond() {
		return wGet(MathFeatureDescriptorEnum.second).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setSecond(Expression second) {
		wSet(MathFeatureDescriptorEnum.second, second);
	}
}
