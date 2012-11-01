package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class StoredProceduresAdapter extends
		AbstractSetEntityAdapter<StoredProcedure> implements StoredProcedures {
	private static final long serialVersionUID = 1;

	public StoredProceduresAdapter(IEntity implementor) {
		super(implementor);
	}

	public StoredProceduresAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StoredProcedures> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.StoredProcedures;
	}
}
