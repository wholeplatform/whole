package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

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

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Template> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.Template;
	}
}
