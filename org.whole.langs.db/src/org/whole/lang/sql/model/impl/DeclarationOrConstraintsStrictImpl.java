package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DeclarationOrConstraintsStrictImpl extends
		AbstractSetCompositeEntity<DeclarationOrConstraint> implements
		DeclarationOrConstraints {
	private static final long serialVersionUID = 1;

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.DeclarationOrConstraints_ord;
	}

	public EntityDescriptor<DeclarationOrConstraints> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.DeclarationOrConstraints;
	}
}
