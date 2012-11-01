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
public class SubsetAdapter extends
		AbstractListEntityAdapter<CollectionExpression> implements Subset {
	private static final long serialVersionUID = 1;

	public SubsetAdapter(IEntity implementor) {
		super(implementor);
	}

	public SubsetAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Subset> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Subset;
	}
}
