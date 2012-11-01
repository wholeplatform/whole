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
public class ForTemplateAdapter extends AbstractEntityAdapter implements
		ForTemplate {
	private static final long serialVersionUID = 1;

	public ForTemplateAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForTemplateAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ForTemplate> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.ForTemplate;
	}

	public Expression getExpression() {
		return wGet(SemanticsFeatureDescriptorEnum.expression).wGetAdapter(
				SemanticsEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(SemanticsFeatureDescriptorEnum.expression, expression);
	}

	public Expression getCondition() {
		return wGet(SemanticsFeatureDescriptorEnum.condition).wGetAdapter(
				SemanticsEntityDescriptorEnum.Expression);
	}

	public void setCondition(Expression condition) {
		wSet(SemanticsFeatureDescriptorEnum.condition, condition);
	}
}
