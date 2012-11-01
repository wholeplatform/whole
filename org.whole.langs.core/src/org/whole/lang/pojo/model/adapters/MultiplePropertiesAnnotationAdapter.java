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
public class MultiplePropertiesAnnotationAdapter extends AbstractEntityAdapter
		implements MultiplePropertiesAnnotation {
	private static final long serialVersionUID = 1;

	public MultiplePropertiesAnnotationAdapter(IEntity implementor) {
		super(implementor);
	}

	public MultiplePropertiesAnnotationAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MultiplePropertiesAnnotation> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.MultiplePropertiesAnnotation;
	}

	public Name getName() {
		return wGet(PojoFeatureDescriptorEnum.name).wGetAdapter(
				PojoEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(PojoFeatureDescriptorEnum.name, name);
	}

	public PropertyValuePairs getPropertyValuePairs() {
		return wGet(PojoFeatureDescriptorEnum.propertyValuePairs).wGetAdapter(
				PojoEntityDescriptorEnum.PropertyValuePairs);
	}

	public void setPropertyValuePairs(PropertyValuePairs propertyValuePairs) {
		wSet(PojoFeatureDescriptorEnum.propertyValuePairs, propertyValuePairs);
	}
}
