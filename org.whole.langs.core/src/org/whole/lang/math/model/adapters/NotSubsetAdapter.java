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
public class NotSubsetAdapter extends AbstractEntityAdapter implements
		NotSubset {
	private static final long serialVersionUID = 1;

	public NotSubsetAdapter(IEntity implementor) {
		super(implementor);
	}

	public NotSubsetAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<NotSubset> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.NotSubset;
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
