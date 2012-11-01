package org.whole.lang.types.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class CasesAdapter extends AbstractListEntityAdapter<Case> implements
		Cases {
	private static final long serialVersionUID = 1;

	public CasesAdapter(IEntity implementor) {
		super(implementor);
	}

	public CasesAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Cases> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.Cases;
	}
}
