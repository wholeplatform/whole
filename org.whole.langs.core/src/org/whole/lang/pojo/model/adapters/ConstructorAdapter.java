package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ConstructorAdapter extends AbstractEntityAdapter implements
		Constructor {
	private static final long serialVersionUID = 1;

	public ConstructorAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConstructorAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Constructor> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Constructor;
	}

	public Parameters getParameters() {
		return wGet(PojoFeatureDescriptorEnum.parameters).wGetAdapter(
				PojoEntityDescriptorEnum.Parameters);
	}

	public void setParameters(Parameters parameters) {
		wSet(PojoFeatureDescriptorEnum.parameters, parameters);
	}
}
