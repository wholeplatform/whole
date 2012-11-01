package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class PremisesImpl extends AbstractListCompositeEntity<Premise>
		implements Premises {
	private static final long serialVersionUID = 1;

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.Premises_ord;
	}

	public EntityDescriptor<Premises> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.Premises;
	}
}
