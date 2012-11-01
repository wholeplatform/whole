package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.math.model.Number;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class NumberAdapter extends AbstractEntityAdapter implements Number {
	private static final long serialVersionUID = 1;

	public NumberAdapter(IEntity implementor) {
		super(implementor);
	}

	public NumberAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Number> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Number;
	}
}
