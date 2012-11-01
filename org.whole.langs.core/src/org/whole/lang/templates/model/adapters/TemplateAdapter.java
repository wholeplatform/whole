package org.whole.lang.templates.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.templates.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TemplateAdapter extends AbstractEntityAdapter implements Template {
	private static final long serialVersionUID = 1;

	public TemplateAdapter(IEntity implementor) {
		super(implementor);
	}

	public TemplateAdapter() {
	}

	public void accept(ITemplatesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Template> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.Template;
	}
}
