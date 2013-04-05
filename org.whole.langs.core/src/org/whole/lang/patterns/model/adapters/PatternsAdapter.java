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
public class PatternsAdapter extends AbstractListEntityAdapter<Pattern>
		implements Patterns {
	private static final long serialVersionUID = 1;

	public PatternsAdapter(IEntity implementor) {
		super(implementor);
	}

	public PatternsAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Patterns> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.Patterns;
	}
}
