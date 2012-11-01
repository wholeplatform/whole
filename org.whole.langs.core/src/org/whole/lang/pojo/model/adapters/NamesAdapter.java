package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class NamesAdapter extends AbstractListEntityAdapter<Name> implements
		Names {
	private static final long serialVersionUID = 1;

	public NamesAdapter(IEntity implementor) {
		super(implementor);
	}

	public NamesAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Names> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Names;
	}
}
