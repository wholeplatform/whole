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
public class UniqueIndexAdapter extends AbstractEntityAdapter implements UniqueIndex {
	private static final long serialVersionUID = 1;

	public UniqueIndexAdapter(IEntity implementor) {
		super(implementor);
	}

	public UniqueIndexAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<UniqueIndex> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.UniqueIndex;
	}
}
