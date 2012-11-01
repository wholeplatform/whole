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
public class TableConstraintAdapter extends AbstractEntityAdapter implements
		TableConstraint {
	private static final long serialVersionUID = 1;

	public TableConstraintAdapter(IEntity implementor) {
		super(implementor);
	}

	public TableConstraintAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TableConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.TableConstraint;
	}
}
