package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DeclarationOrConstraintAdapter extends AbstractEntityAdapter
		implements DeclarationOrConstraint {
	private static final long serialVersionUID = 1;

	public DeclarationOrConstraintAdapter(IEntity implementor) {
		super(implementor);
	}

	public DeclarationOrConstraintAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DeclarationOrConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.DeclarationOrConstraint;
	}
}
