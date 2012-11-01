package org.whole.lang.commons.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.commons.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ResolverAdapter extends AbstractEntityAdapter implements Resolver {
	private static final long serialVersionUID = 1;

	public ResolverAdapter(IEntity implementor) {
		super(implementor);
	}

	public ResolverAdapter() {
	}

	public void accept(ICommonsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Resolver> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.Resolver;
	}
}
