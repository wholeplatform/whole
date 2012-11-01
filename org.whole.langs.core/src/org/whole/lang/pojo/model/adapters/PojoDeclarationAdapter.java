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
public class PojoDeclarationAdapter extends AbstractEntityAdapter implements
		PojoDeclaration {
	private static final long serialVersionUID = 1;

	public PojoDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public PojoDeclarationAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PojoDeclaration> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.PojoDeclaration;
	}

	public Annotations getAnnotations() {
		return wGet(PojoFeatureDescriptorEnum.annotations).wGetAdapter(
				PojoEntityDescriptorEnum.Annotations);
	}

	public void setAnnotations(Annotations annotations) {
		wSet(PojoFeatureDescriptorEnum.annotations, annotations);
	}

	public Template getTemplate() {
		return wGet(PojoFeatureDescriptorEnum.template).wGetAdapter(
				PojoEntityDescriptorEnum.Template);
	}

	public void setTemplate(Template template) {
		wSet(PojoFeatureDescriptorEnum.template, template);
	}

	public ReferenceType getName() {
		return wGet(PojoFeatureDescriptorEnum.name).wGetAdapter(
				PojoEntityDescriptorEnum.ReferenceType);
	}

	public void setName(ReferenceType name) {
		wSet(PojoFeatureDescriptorEnum.name, name);
	}

	public ReferenceTypes getTypes() {
		return wGet(PojoFeatureDescriptorEnum.types).wGetAdapter(
				PojoEntityDescriptorEnum.ReferenceTypes);
	}

	public void setTypes(ReferenceTypes types) {
		wSet(PojoFeatureDescriptorEnum.types, types);
	}

	public Properties getProperties() {
		return wGet(PojoFeatureDescriptorEnum.properties).wGetAdapter(
				PojoEntityDescriptorEnum.Properties);
	}

	public void setProperties(Properties properties) {
		wSet(PojoFeatureDescriptorEnum.properties, properties);
	}

	public Constructors getConstructors() {
		return wGet(PojoFeatureDescriptorEnum.constructors).wGetAdapter(
				PojoEntityDescriptorEnum.Constructors);
	}

	public void setConstructors(Constructors constructors) {
		wSet(PojoFeatureDescriptorEnum.constructors, constructors);
	}
}
