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
public class InlineTemplateAdapter extends AbstractEntityAdapter implements
		InlineTemplate {
	private static final long serialVersionUID = 1;

	public InlineTemplateAdapter(IEntity implementor) {
		super(implementor);
	}

	public InlineTemplateAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InlineTemplate> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.InlineTemplate;
	}

	public Expression getExpression() {
		return wGet(SemanticsFeatureDescriptorEnum.expression).wGetAdapter(
				SemanticsEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(SemanticsFeatureDescriptorEnum.expression, expression);
	}
}
