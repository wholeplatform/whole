package org.whole.lang.templates.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.templates.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;
import org.whole.lang.templates.reflect.TemplatesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class TemplateFactoryAdapter extends AbstractEntityAdapter implements
		TemplateFactory {
	private static final long serialVersionUID = 1;

	public TemplateFactoryAdapter(IEntity implementor) {
		super(implementor);
	}

	public TemplateFactoryAdapter() {
	}

	public void accept(ITemplatesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TemplateFactory> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.TemplateFactory;
	}

	public SimpleName getName() {
		return wGet(TemplatesFeatureDescriptorEnum.name).wGetAdapter(
				TemplatesEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(TemplatesFeatureDescriptorEnum.name, name);
	}

	public Names getForNames() {
		return wGet(TemplatesFeatureDescriptorEnum.forNames).wGetAdapter(
				TemplatesEntityDescriptorEnum.Names);
	}

	public void setForNames(Names forNames) {
		wSet(TemplatesFeatureDescriptorEnum.forNames, forNames);
	}

	public Template getTemplate() {
		return wGet(TemplatesFeatureDescriptorEnum.template).wGetAdapter(
				TemplatesEntityDescriptorEnum.Template);
	}

	public void setTemplate(Template template) {
		wSet(TemplatesFeatureDescriptorEnum.template, template);
	}
}
