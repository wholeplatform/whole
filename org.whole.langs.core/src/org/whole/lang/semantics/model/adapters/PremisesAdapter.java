package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PremisesAdapter extends AbstractListEntityAdapter<Premise>
		implements Premises {
	private static final long serialVersionUID = 1;

	public PremisesAdapter(IEntity implementor) {
		super(implementor);
	}

	public PremisesAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Premises> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.Premises;
	}
}
