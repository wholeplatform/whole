package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class IndexDeclarationsStrictImpl extends AbstractSetCompositeEntity<IndexDeclaration>
		implements IndexDeclarations {
	private static final long serialVersionUID = 1;

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.IndexDeclarations_ord;
	}

	public EntityDescriptor<IndexDeclarations> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.IndexDeclarations;
	}
}
