package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FactoryMethodsAdapter extends
		AbstractListEntityAdapter<FactoryMethod> implements FactoryMethods {
	private static final long serialVersionUID = 1;

	public FactoryMethodsAdapter(IEntity implementor) {
		super(implementor);
	}

	public FactoryMethodsAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FactoryMethods> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.FactoryMethods;
	}
}
