package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MinimumAdapter extends AbstractListEntityAdapter<Expression>
		implements Minimum {
	private static final long serialVersionUID = 1;

	public MinimumAdapter(IEntity implementor) {
		super(implementor);
	}

	public MinimumAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Minimum> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Minimum;
	}
}
