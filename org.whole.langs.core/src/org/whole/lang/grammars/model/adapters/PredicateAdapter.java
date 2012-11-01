package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;

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

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Predicate> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Predicate;
	}
}
