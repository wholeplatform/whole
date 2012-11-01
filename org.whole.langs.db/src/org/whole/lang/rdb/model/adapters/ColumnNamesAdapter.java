package org.whole.lang.rdb.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ColumnNamesAdapter extends AbstractListEntityAdapter<StringData>
		implements ColumnNames {
	private static final long serialVersionUID = 1;

	public ColumnNamesAdapter(IEntity implementor) {
		super(implementor);
	}

	public ColumnNamesAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ColumnNames> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.ColumnNames;
	}
}
