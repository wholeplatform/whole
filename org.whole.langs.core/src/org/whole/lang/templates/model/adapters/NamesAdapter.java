package org.whole.lang.templates.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.templates.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class NamesAdapter extends AbstractSetEntityAdapter<Name> implements
		Names {
	private static final long serialVersionUID = 1;

	public NamesAdapter(IEntity implementor) {
		super(implementor);
	}

	public NamesAdapter() {
	}

	public void accept(ITemplatesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Names> wGetEntityDescriptor() {
		return TemplatesEntityDescriptorEnum.Names;
	}
}
