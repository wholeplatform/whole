package org.whole.lang.scheme.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class BranchesAdapter extends AbstractListEntityAdapter<Branch>
		implements Branches {
	private static final long serialVersionUID = 1;

	public BranchesAdapter(IEntity implementor) {
		super(implementor);
	}

	public BranchesAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Branches> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.Branches;
	}
}
