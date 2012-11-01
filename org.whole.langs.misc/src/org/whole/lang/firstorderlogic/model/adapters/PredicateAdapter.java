package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PredicateAdapter extends AbstractEntityAdapter implements
		Predicate {
	private static final long serialVersionUID = 1;

	public PredicateAdapter(IEntity implementor) {
		super(implementor);
	}

	public PredicateAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Predicate> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Predicate;
	}
}
