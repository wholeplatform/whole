package org.whole.lang.templates.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.templates.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TemplatesAdapter extends
		AbstractListEntityAdapter<TemplateFactory> implements Templates {
	private static final long serialVersionUID = 1;

	public TemplatesAdapter(IEntity implementor) {
		super(implementor);
	}

	public TemplatesAdapter() {
	}

	public void accept(ITemplatesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Templates> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.Templates;
	}
}
