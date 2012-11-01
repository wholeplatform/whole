package org.whole.lang.templates.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.templates.reflect.TemplatesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class TemplatesModelContext extends EntityContext {
	public TemplatesModelContext(IEntity root) {
		super(root);
	}

	public TemplatesModelContext getName() {
		return (TemplatesModelContext) wGet(TemplatesFeatureDescriptorEnum.name);
	}

	public void setName(TemplatesModelContext name) {
		wSet(TemplatesFeatureDescriptorEnum.name, name);
	}

	public TemplatesModelContext getTemplates() {
		return (TemplatesModelContext) wGet(TemplatesFeatureDescriptorEnum.templates);
	}

	public void setTemplates(TemplatesModelContext templates) {
		wSet(TemplatesFeatureDescriptorEnum.templates, templates);
	}

	public TemplatesModelContext getForNames() {
		return (TemplatesModelContext) wGet(TemplatesFeatureDescriptorEnum.forNames);
	}

	public void setForNames(TemplatesModelContext forNames) {
		wSet(TemplatesFeatureDescriptorEnum.forNames, forNames);
	}

	public TemplatesModelContext getTemplate() {
		return (TemplatesModelContext) wGet(TemplatesFeatureDescriptorEnum.template);
	}

	public void setTemplate(TemplatesModelContext template) {
		wSet(TemplatesFeatureDescriptorEnum.template, template);
	}

	public TemplatesModelContext getQualifier() {
		return (TemplatesModelContext) wGet(TemplatesFeatureDescriptorEnum.qualifier);
	}

	public void setQualifier(TemplatesModelContext qualifier) {
		wSet(TemplatesFeatureDescriptorEnum.qualifier, qualifier);
	}
}
