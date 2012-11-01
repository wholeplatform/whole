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
public class ListAdapter extends AbstractEntityAdapter implements List {
	private static final long serialVersionUID = 1;

	public ListAdapter(IEntity implementor) {
		super(implementor);
	}

	public ListAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<List> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.List;
	}

	public Constructor getElements() {
		return wGet(MathFeatureDescriptorEnum.elements).wGetAdapter(
				MathEntityDescriptorEnum.Constructor);
	}

	public void setElements(Constructor elements) {
		wSet(MathFeatureDescriptorEnum.elements, elements);
	}
}
