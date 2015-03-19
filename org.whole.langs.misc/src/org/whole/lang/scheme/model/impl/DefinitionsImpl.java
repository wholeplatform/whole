package org.whole.lang.scheme.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.scheme.model.*;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DefinitionsImpl extends AbstractListCompositeEntity<Definition>
		implements Definitions {
	private static final long serialVersionUID = 1;

	public void accept(ISchemeVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.Definitions_ord;
	}

	public EntityDescriptor<Definitions> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.Definitions;
	}
}
