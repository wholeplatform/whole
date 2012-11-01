package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class IfTemplateAdapter extends AbstractEntityAdapter implements
		IfTemplate {
	private static final long serialVersionUID = 1;

	public IfTemplateAdapter(IEntity implementor) {
		super(implementor);
	}

	public IfTemplateAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IfTemplate> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.IfTemplate;
	}

	public Expression getExpression() {
		return wGet(SemanticsFeatureDescriptorEnum.expression).wGetAdapter(
				SemanticsEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(SemanticsFeatureDescriptorEnum.expression, expression);
	}

	public Predicate getCondition() {
		return wGet(SemanticsFeatureDescriptorEnum.condition).wGetAdapter(
				SemanticsEntityDescriptorEnum.Predicate);
	}

	public void setCondition(Predicate condition) {
		wSet(SemanticsFeatureDescriptorEnum.condition, condition);
	}
}
