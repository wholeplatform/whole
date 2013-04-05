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
public class StepExpressionAdapter extends AbstractEntityAdapter implements
		StepExpression {
	private static final long serialVersionUID = 1;

	public StepExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public StepExpressionAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StepExpression> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.StepExpression;
	}
}
