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
public class GreaterThanAdapter extends AbstractListEntityAdapter<Expression>
		implements GreaterThan {
	private static final long serialVersionUID = 1;

	public GreaterThanAdapter(IEntity implementor) {
		super(implementor);
	}

	public GreaterThanAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<GreaterThan> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.GreaterThan;
	}
}
