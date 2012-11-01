package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class IdentityConstraintDefsAdapter extends
		AbstractListEntityAdapter<IdentityConstraintDef> implements
		IdentityConstraintDefs {
	private static final long serialVersionUID = 1;

	public IdentityConstraintDefsAdapter(IEntity implementor) {
		super(implementor);
	}

	public IdentityConstraintDefsAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IdentityConstraintDefs> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.IdentityConstraintDefs;
	}
}
