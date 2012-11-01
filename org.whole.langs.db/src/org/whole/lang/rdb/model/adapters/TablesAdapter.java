package org.whole.lang.rdb.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TablesAdapter extends AbstractSetEntityAdapter<Table> implements
		Tables {
	private static final long serialVersionUID = 1;

	public TablesAdapter(IEntity implementor) {
		super(implementor);
	}

	public TablesAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Tables> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Tables;
	}
}
