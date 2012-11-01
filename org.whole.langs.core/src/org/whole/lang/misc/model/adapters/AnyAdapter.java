package org.whole.lang.misc.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.misc.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.misc.visitors.IMiscVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.misc.reflect.MiscEntityDescriptorEnum;

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

	public void accept(IMiscVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Any> wGetEntityDescriptor() {
		return MiscEntityDescriptorEnum.Any;
	}
}
