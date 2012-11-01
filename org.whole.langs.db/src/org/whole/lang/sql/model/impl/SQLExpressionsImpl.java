package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SQLExpressionsImpl extends
		AbstractListCompositeEntity<SQLExpression> implements SQLExpressions {
	private static final long serialVersionUID = 1;

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.SQLExpressions_ord;
	}

	public EntityDescriptor<SQLExpressions> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.SQLExpressions;
	}
}
