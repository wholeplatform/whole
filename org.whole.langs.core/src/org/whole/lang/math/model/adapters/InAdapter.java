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
public class InAdapter extends AbstractEntityAdapter implements In {
	private static final long serialVersionUID = 1;

	public InAdapter(IEntity implementor) {
		super(implementor);
	}

	public InAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<In> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.In;
	}

	public Expression getElement() {
		return wGet(MathFeatureDescriptorEnum.element).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setElement(Expression element) {
		wSet(MathFeatureDescriptorEnum.element, element);
	}

	public CollectionExpression getCollection() {
		return wGet(MathFeatureDescriptorEnum.collection).wGetAdapter(
				MathEntityDescriptorEnum.CollectionExpression);
	}

	public void setCollection(CollectionExpression collection) {
		wSet(MathFeatureDescriptorEnum.collection, collection);
	}
}
