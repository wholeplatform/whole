package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

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

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Predicate> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.Predicate;
	}
}
