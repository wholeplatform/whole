package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class AnnotationDeclarationImpl extends AbstractSimpleEntity implements
		AnnotationDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AnnotationDeclaration> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.AnnotationDeclaration;
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.AnnotationDeclaration_ord;
	}

	public void accept(IPojoVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Annotations annotations;

	public Annotations getAnnotations() {
		return notifyRequested(PojoFeatureDescriptorEnum.annotations,
				annotations);
	}

	public void setAnnotations(Annotations annotations) {
		notifyChanged(PojoFeatureDescriptorEnum.annotations, this.annotations,
				this.annotations = annotations);
	}

	private Template template;

	public Template getTemplate() {
		return notifyRequested(PojoFeatureDescriptorEnum.template, template);
	}

	public void setTemplate(Template template) {
		notifyChanged(PojoFeatureDescriptorEnum.template, this.template,
				this.template = template);
	}

	private ReferenceType name;

	public ReferenceType getName() {
		return notifyRequested(PojoFeatureDescriptorEnum.name, name);
	}

	public void setName(ReferenceType name) {
		notifyChanged(PojoFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Properties properties;

	public Properties getProperties() {
		return notifyRequested(PojoFeatureDescriptorEnum.properties, properties);
	}

	public void setProperties(Properties properties) {
		notifyChanged(PojoFeatureDescriptorEnum.properties, this.properties,
				this.properties = properties);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getAnnotations().wGetAdaptee(false);
		case 1:
			return getTemplate().wGetAdaptee(false);
		case 2:
			return getName().wGetAdaptee(false);
		case 3:
			return getProperties().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setAnnotations(value
					.wGetAdapter(PojoEntityDescriptorEnum.Annotations));
			break;
		case 1:
			setTemplate(value.wGetAdapter(PojoEntityDescriptorEnum.Template));
			break;
		case 2:
			setName(value.wGetAdapter(PojoEntityDescriptorEnum.ReferenceType));
			break;
		case 3:
			setProperties(value
					.wGetAdapter(PojoEntityDescriptorEnum.Properties));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
