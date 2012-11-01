package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class IndexDeclarationsStrictImpl extends
		AbstractSetCompositeEntity<IndexDeclaration> implements
		IndexDeclarations {
	private static final long serialVersionUID = 1;

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.IndexDeclarations_ord;
	}

	public EntityDescriptor<IndexDeclarations> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.IndexDeclarations;
	}
}
