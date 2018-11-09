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
public class SQLExpressionsAdapter extends AbstractListEntityAdapter<SQLExpression> implements SQLExpressions {
	private static final long serialVersionUID = 1;

	public SQLExpressionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public SQLExpressionsAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SQLExpressions> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.SQLExpressions;
	}
}
