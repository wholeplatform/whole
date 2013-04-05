package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class DerivationPointAdapter extends AbstractEntityAdapter implements
		DerivationPoint {
	private static final long serialVersionUID = 1;

	public DerivationPointAdapter(IEntity implementor) {
		super(implementor);
	}

	public DerivationPointAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DerivationPoint> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.DerivationPoint;
	}

	public Expression getExpression() {
		return wGet(PatternsFeatureDescriptorEnum.expression).wGetAdapter(
				PatternsEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(PatternsFeatureDescriptorEnum.expression, expression);
	}

	public ResultType getResultType() {
		return wGet(PatternsFeatureDescriptorEnum.resultType).wGetAdapter(
				PatternsEntityDescriptorEnum.ResultType);
	}

	public void setResultType(ResultType resultType) {
		wSet(PatternsFeatureDescriptorEnum.resultType, resultType);
	}
}
