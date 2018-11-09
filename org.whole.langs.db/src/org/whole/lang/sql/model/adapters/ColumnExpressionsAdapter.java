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
public class ColumnExpressionsAdapter extends AbstractListEntityAdapter<ColumnExpression> implements ColumnExpressions {
	private static final long serialVersionUID = 1;

	public ColumnExpressionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ColumnExpressionsAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ColumnExpressions> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ColumnExpressions;
	}
}
