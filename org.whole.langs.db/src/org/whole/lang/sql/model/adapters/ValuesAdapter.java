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
public class ValuesAdapter extends AbstractListEntityAdapter<SQLExpressions>
		implements Values {
	private static final long serialVersionUID = 1;

	public ValuesAdapter(IEntity implementor) {
		super(implementor);
	}

	public ValuesAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Values> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Values;
	}
}
