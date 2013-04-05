package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SequencePointAdapter extends AbstractListEntityAdapter<Template>
		implements SequencePoint {
	private static final long serialVersionUID = 1;

	public SequencePointAdapter(IEntity implementor) {
		super(implementor);
	}

	public SequencePointAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SequencePoint> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.SequencePoint;
	}
}
