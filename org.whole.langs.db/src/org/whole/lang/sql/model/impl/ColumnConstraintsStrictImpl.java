package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ColumnConstraintsStrictImpl extends
		AbstractSetCompositeEntity<ColumnConstraint> implements
		ColumnConstraints {
	private static final long serialVersionUID = 1;

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.ColumnConstraints_ord;
	}

	public EntityDescriptor<ColumnConstraints> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ColumnConstraints;
	}
}
