package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class BuilderAdapter extends AbstractEntityAdapter implements Builder {
	private static final long serialVersionUID = 1;

	public BuilderAdapter(IEntity implementor) {
		super(implementor);
	}

	public BuilderAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Builder> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Builder;
	}

	public Expression getElement() {
		return wGet(MathFeatureDescriptorEnum.element).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setElement(Expression element) {
		wSet(MathFeatureDescriptorEnum.element, element);
	}

	public Expression getRule() {
		return wGet(MathFeatureDescriptorEnum.rule).wGetAdapter(
				MathEntityDescriptorEnum.Expression);
	}

	public void setRule(Expression rule) {
		wSet(MathFeatureDescriptorEnum.rule, rule);
	}
}
