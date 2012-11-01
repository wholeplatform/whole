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
public class SelectorAdapter extends AbstractEntityAdapter implements Selector {
	private static final long serialVersionUID = 1;

	public SelectorAdapter(IEntity implementor) {
		super(implementor);
	}

	public SelectorAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Selector> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Selector;
	}

	public Expression getIndex() {
		return wGet(MathFeatureDescriptorEnum.index).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setIndex(Expression index) {
		wSet(MathFeatureDescriptorEnum.index, index);
	}

	public CollectionExpression getCollection() {
		return wGet(MathFeatureDescriptorEnum.collection).wGetAdapter(
				MathEntityDescriptorEnum.CollectionExpression);
	}

	public void setCollection(CollectionExpression collection) {
		wSet(MathFeatureDescriptorEnum.collection, collection);
	}
}
