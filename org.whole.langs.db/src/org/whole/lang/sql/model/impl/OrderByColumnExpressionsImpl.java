package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class OrderByColumnExpressionsImpl extends
		AbstractListCompositeEntity<OrderByColumnExpression> implements
		OrderByColumnExpressions {
	private static final long serialVersionUID = 1;

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.OrderByColumnExpressions_ord;
	}

	public EntityDescriptor<OrderByColumnExpressions> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.OrderByColumnExpressions;
	}
}
