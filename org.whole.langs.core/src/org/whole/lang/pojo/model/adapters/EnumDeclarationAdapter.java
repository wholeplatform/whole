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
public class EnumDeclarationAdapter extends AbstractEntityAdapter implements
		EnumDeclaration {
	private static final long serialVersionUID = 1;

	public EnumDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public EnumDeclarationAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EnumDeclaration> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.EnumDeclaration;
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

	public Names getValues() {
		return wGet(PojoFeatureDescriptorEnum.values).wGetAdapter(
				PojoEntityDescriptorEnum.Names);
	}

	public void setValues(Names values) {
		wSet(PojoFeatureDescriptorEnum.values, values);
	}
}
