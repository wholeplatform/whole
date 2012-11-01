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
public class InputBindingAdapter extends AbstractEntityAdapter implements
		InputBinding {
	private static final long serialVersionUID = 1;

	public InputBindingAdapter(IEntity implementor) {
		super(implementor);
	}

	public InputBindingAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InputBinding> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.InputBinding;
	}

	public BindingSubject getIdentifier() {
		return wGet(SemanticsFeatureDescriptorEnum.identifier).wGetAdapter(
				SemanticsEntityDescriptorEnum.BindingSubject);
	}

	public void setIdentifier(BindingSubject identifier) {
		wSet(SemanticsFeatureDescriptorEnum.identifier, identifier);
	}

	public Expression getExpression() {
		return wGet(SemanticsFeatureDescriptorEnum.expression).wGetAdapter(
				SemanticsEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(SemanticsFeatureDescriptorEnum.expression, expression);
	}
}
