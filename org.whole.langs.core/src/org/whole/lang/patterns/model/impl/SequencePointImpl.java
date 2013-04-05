package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SequencePointImpl extends AbstractListCompositeEntity<Template>
		implements SequencePoint {
	private static final long serialVersionUID = 1;

	public void accept(IPatternsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return PatternsEntityDescriptorEnum.SequencePoint_ord;
	}

	public EntityDescriptor<SequencePoint> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.SequencePoint;
	}
}
