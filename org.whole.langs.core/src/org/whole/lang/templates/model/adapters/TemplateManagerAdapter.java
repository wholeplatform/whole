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
public class TemplateManagerAdapter extends AbstractEntityAdapter implements
		TemplateManager {
	private static final long serialVersionUID = 1;

	public TemplateManagerAdapter(IEntity implementor) {
		super(implementor);
	}

	public TemplateManagerAdapter() {
	}

	public void accept(ITemplatesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TemplateManager> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.TemplateManager;
	}

	public SimpleName getName() {
		return wGet(TemplatesFeatureDescriptorEnum.name).wGetAdapter(
				TemplatesEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(TemplatesFeatureDescriptorEnum.name, name);
	}

	public Templates getTemplates() {
		return wGet(TemplatesFeatureDescriptorEnum.templates).wGetAdapter(
				TemplatesEntityDescriptorEnum.Templates);
	}

	public void setTemplates(Templates templates) {
		wSet(TemplatesFeatureDescriptorEnum.templates, templates);
	}
}
