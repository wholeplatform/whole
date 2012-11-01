package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EmptyAdapter extends AbstractEntityAdapter implements Empty {
	private static final long serialVersionUID = 1;

	public EmptyAdapter(IEntity implementor) {
		super(implementor);
	}

	public EmptyAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Empty> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Empty;
	}
}
