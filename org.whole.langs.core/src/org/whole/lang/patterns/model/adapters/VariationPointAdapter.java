package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class VariationPointAdapter extends AbstractEntityAdapter implements
		VariationPoint {
	private static final long serialVersionUID = 1;

	public VariationPointAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariationPointAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariationPoint> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.VariationPoint;
	}
}
