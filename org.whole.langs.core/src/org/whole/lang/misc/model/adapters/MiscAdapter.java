package org.whole.lang.misc.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.misc.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.misc.visitors.IMiscVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.misc.reflect.MiscEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MiscAdapter extends AbstractListEntityAdapter<Any> implements Misc {
	private static final long serialVersionUID = 1;

	public MiscAdapter(IEntity implementor) {
		super(implementor);
	}

	public MiscAdapter() {
	}

	public void accept(IMiscVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Misc> wGetEntityDescriptor() {
		return MiscEntityDescriptorEnum.Misc;
	}
}
