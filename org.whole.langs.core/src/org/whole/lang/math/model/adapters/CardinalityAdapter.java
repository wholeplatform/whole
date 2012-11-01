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
public class CardinalityAdapter extends AbstractEntityAdapter implements
		Cardinality {
	private static final long serialVersionUID = 1;

	public CardinalityAdapter(IEntity implementor) {
		super(implementor);
	}

	public CardinalityAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Cardinality> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Cardinality;
	}

	public CollectionExpression getCollection() {
		return wGet(MathFeatureDescriptorEnum.collection).wGetAdapter(
				MathEntityDescriptorEnum.CollectionExpression);
	}

	public void setCollection(CollectionExpression collection) {
		wSet(MathFeatureDescriptorEnum.collection, collection);
	}
}
