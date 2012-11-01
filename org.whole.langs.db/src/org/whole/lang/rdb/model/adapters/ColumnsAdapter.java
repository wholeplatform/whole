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
public class ColumnsAdapter extends AbstractListEntityAdapter<Column> implements
		Columns {
	private static final long serialVersionUID = 1;

	public ColumnsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ColumnsAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Columns> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Columns;
	}
}
