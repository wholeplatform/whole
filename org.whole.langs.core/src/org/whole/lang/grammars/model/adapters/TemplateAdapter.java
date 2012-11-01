package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;

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

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Template> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Template;
	}
}
