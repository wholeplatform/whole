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
public class AnyAdapter extends AbstractEntityAdapter implements Any {
	private static final long serialVersionUID = 1;

	public AnyAdapter(IEntity implementor) {
		super(implementor);
	}

	public AnyAdapter() {
	}

	public void accept(ICommonsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Any> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.Any;
	}
}
