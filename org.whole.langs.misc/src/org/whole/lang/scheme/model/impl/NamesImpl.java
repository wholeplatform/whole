package org.whole.lang.scheme.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.scheme.model.*;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class NamesImpl extends AbstractListCompositeEntity<Name> implements
		Names {
	private static final long serialVersionUID = 1;

	public void accept(ISchemeVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.Names_ord;
	}

	public EntityDescriptor<Names> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.Names;
	}
}
