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
public class TemplateManagerImpl extends AbstractSimpleEntity implements
		TemplateManager {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TemplateManager> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.TemplateManager;
	}

	public int wGetEntityOrd() {
		return TemplatesEntityDescriptorEnum.TemplateManager_ord;
	}

	public void accept(ITemplatesVisitor visitor) {
		visitor.visit(this);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(TemplatesFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(TemplatesFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Templates templates;

	public Templates getTemplates() {
		return notifyRequested(TemplatesFeatureDescriptorEnum.templates,
				templates);
	}

	public void setTemplates(Templates templates) {
		notifyChanged(TemplatesFeatureDescriptorEnum.templates, this.templates,
				this.templates = templates);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getTemplates().wGetAdaptee(false);
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
			setTemplates(value
					.wGetAdapter(TemplatesEntityDescriptorEnum.Templates));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
