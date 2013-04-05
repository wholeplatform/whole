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
public class ResultTypeOrPathExpressionAdapter extends AbstractEntityAdapter
		implements ResultTypeOrPathExpression {
	private static final long serialVersionUID = 1;

	public ResultTypeOrPathExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ResultTypeOrPathExpressionAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ResultTypeOrPathExpression> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.ResultTypeOrPathExpression;
	}
}
