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
public class WhereTemplateAdapter extends AbstractEntityAdapter implements
		WhereTemplate {
	private static final long serialVersionUID = 1;

	public WhereTemplateAdapter(IEntity implementor) {
		super(implementor);
	}

	public WhereTemplateAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<WhereTemplate> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.WhereTemplate;
	}

	public Expression getExpression() {
		return wGet(SemanticsFeatureDescriptorEnum.expression).wGetAdapter(
				SemanticsEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(SemanticsFeatureDescriptorEnum.expression, expression);
	}

	public InputBindings getWhere() {
		return wGet(SemanticsFeatureDescriptorEnum.where).wGetAdapter(
				SemanticsEntityDescriptorEnum.InputBindings);
	}

	public void setWhere(InputBindings where) {
		wSet(SemanticsFeatureDescriptorEnum.where, where);
	}
}
