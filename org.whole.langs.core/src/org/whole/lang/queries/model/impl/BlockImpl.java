package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class BlockImpl extends AbstractListCompositeEntity<PathExpression>
		implements Block {
	private static final long serialVersionUID = 1;

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.Block_ord;
	}

	public EntityDescriptor<Block> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.Block;
	}
}
