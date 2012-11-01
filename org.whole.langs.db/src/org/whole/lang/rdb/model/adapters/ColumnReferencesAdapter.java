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
public class ColumnReferencesAdapter extends
		AbstractListEntityAdapter<ColumnReference> implements ColumnReferences {
	private static final long serialVersionUID = 1;

	public ColumnReferencesAdapter(IEntity implementor) {
		super(implementor);
	}

	public ColumnReferencesAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ColumnReferences> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.ColumnReferences;
	}
}
