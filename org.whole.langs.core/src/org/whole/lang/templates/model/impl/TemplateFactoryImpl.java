package org.whole.lang.templates.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.templates.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.templates.reflect.TemplatesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TemplateFactoryImpl extends AbstractSimpleEntity implements
		TemplateFactory {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TemplateFactory> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.TemplateFactory;
	}

	public int wGetEntityOrd() {
		return TemplatesEntityDescriptorEnum.TemplateFactory_ord;
	}

	public void accept(ITemplatesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName().wEquals(
					entity.wGet(TemplatesFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(TemplatesFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(TemplatesFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Names forNames;

	public Names getForNames() {
		return notifyRequested(TemplatesFeatureDescriptorEnum.forNames,
				forNames);
	}

	public void setForNames(Names forNames) {
		notifyChanged(TemplatesFeatureDescriptorEnum.forNames, this.forNames,
				this.forNames = forNames);
	}

	private Template template;

	public Template getTemplate() {
		return notifyRequested(TemplatesFeatureDescriptorEnum.template,
				template);
	}

	public void setTemplate(Template template) {
		notifyChanged(TemplatesFeatureDescriptorEnum.template, this.template,
				this.template = template);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getForNames().wGetAdaptee(false);
		case 2:
			return getTemplate().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(TemplatesEntityDescriptorEnum.SimpleName));
			break;
		case 1:
			setForNames(value.wGetAdapter(TemplatesEntityDescriptorEnum.Names));
			break;
		case 2:
			setTemplate(value
					.wGetAdapter(TemplatesEntityDescriptorEnum.Template));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
