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
public class PatternJoinPointStepAdapter extends AbstractEntityAdapter
		implements PatternJoinPointStep {
	private static final long serialVersionUID = 1;

	public PatternJoinPointStepAdapter(IEntity implementor) {
		super(implementor);
	}

	public PatternJoinPointStepAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PatternJoinPointStep> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.PatternJoinPointStep;
	}
}
