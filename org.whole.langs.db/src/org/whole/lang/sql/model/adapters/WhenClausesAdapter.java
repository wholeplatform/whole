package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class WhenClausesAdapter extends AbstractListEntityAdapter<WhenClause>
		implements WhenClauses {
	private static final long serialVersionUID = 1;

	public WhenClausesAdapter(IEntity implementor) {
		super(implementor);
	}

	public WhenClausesAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<WhenClauses> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.WhenClauses;
	}
}
