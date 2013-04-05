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
public class ArgumentAdapter extends AbstractEntityAdapter implements Argument {
	private static final long serialVersionUID = 1;

	public ArgumentAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArgumentAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Argument> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.Argument;
	}
}
