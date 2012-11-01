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
public class AlterActionAdapter extends AbstractEntityAdapter implements
		AlterAction {
	private static final long serialVersionUID = 1;

	public AlterActionAdapter(IEntity implementor) {
		super(implementor);
	}

	public AlterActionAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AlterAction> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.AlterAction;
	}
}
