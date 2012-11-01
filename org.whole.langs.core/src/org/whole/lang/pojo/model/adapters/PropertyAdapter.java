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
public class PropertyAdapter extends AbstractEntityAdapter implements Property {
	private static final long serialVersionUID = 1;

	public PropertyAdapter(IEntity implementor) {
		super(implementor);
	}

	public PropertyAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Property> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Property;
	}

	public Annotations getAnnotations() {
		return wGet(PojoFeatureDescriptorEnum.annotations).wGetAdapter(
				PojoEntityDescriptorEnum.Annotations);
	}

	public void setAnnotations(Annotations annotations) {
		wSet(PojoFeatureDescriptorEnum.annotations, annotations);
	}

	public Type getType() {
		return wGet(PojoFeatureDescriptorEnum.type).wGetAdapter(
				PojoEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(PojoFeatureDescriptorEnum.type, type);
	}

	public Name getName() {
		return wGet(PojoFeatureDescriptorEnum.name).wGetAdapter(
				PojoEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(PojoFeatureDescriptorEnum.name, name);
	}

	public Name getTemplate() {
		return wGet(PojoFeatureDescriptorEnum.template).wGetAdapter(
				PojoEntityDescriptorEnum.Name);
	}

	public void setTemplate(Name template) {
		wSet(PojoFeatureDescriptorEnum.template, template);
	}
}
