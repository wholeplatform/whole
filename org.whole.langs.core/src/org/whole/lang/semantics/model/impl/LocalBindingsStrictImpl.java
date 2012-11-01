package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class LocalBindingsStrictImpl extends
		AbstractSetCompositeEntity<LocalBinding> implements LocalBindings {
	private static final long serialVersionUID = 1;

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.LocalBindings_ord;
	}

	public EntityDescriptor<LocalBindings> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.LocalBindings;
	}
}
