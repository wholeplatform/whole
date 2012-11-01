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
public class ConstructorsAdapter extends AbstractListEntityAdapter<Constructor>
		implements Constructors {
	private static final long serialVersionUID = 1;

	public ConstructorsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConstructorsAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Constructors> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Constructors;
	}
}
