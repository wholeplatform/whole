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
public class SinglePropertyAnnotationAdapter extends AbstractEntityAdapter
		implements SinglePropertyAnnotation {
	private static final long serialVersionUID = 1;

	public SinglePropertyAnnotationAdapter(IEntity implementor) {
		super(implementor);
	}

	public SinglePropertyAnnotationAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SinglePropertyAnnotation> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.SinglePropertyAnnotation;
	}

	public Name getName() {
		return wGet(PojoFeatureDescriptorEnum.name).wGetAdapter(
				PojoEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(PojoFeatureDescriptorEnum.name, name);
	}

	public PropertyValue getValue() {
		return wGet(PojoFeatureDescriptorEnum.value).wGetAdapter(
				PojoEntityDescriptorEnum.PropertyValue);
	}

	public void setValue(PropertyValue value) {
		wSet(PojoFeatureDescriptorEnum.value, value);
	}
}
