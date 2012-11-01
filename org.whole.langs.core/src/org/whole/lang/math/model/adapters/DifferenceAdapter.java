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
public class DifferenceAdapter extends AbstractEntityAdapter implements
		Difference {
	private static final long serialVersionUID = 1;

	public DifferenceAdapter(IEntity implementor) {
		super(implementor);
	}

	public DifferenceAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Difference> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Difference;
	}

	public CollectionExpression getCollection1() {
		return wGet(MathFeatureDescriptorEnum.collection1).wGetAdapter(
				MathEntityDescriptorEnum.CollectionExpression);
	}

	public void setCollection1(CollectionExpression collection1) {
		wSet(MathFeatureDescriptorEnum.collection1, collection1);
	}

	public CollectionExpression getCollection2() {
		return wGet(MathFeatureDescriptorEnum.collection2).wGetAdapter(
				MathEntityDescriptorEnum.CollectionExpression);
	}

	public void setCollection2(CollectionExpression collection2) {
		wSet(MathFeatureDescriptorEnum.collection2, collection2);
	}
}
