package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class OutputBindingImpl extends AbstractSimpleEntity implements
		OutputBinding {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<OutputBinding> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.OutputBinding;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.OutputBinding_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private BindingSubject identifier;

	public BindingSubject getIdentifier() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.identifier,
				identifier);
	}

	public void setIdentifier(BindingSubject identifier) {
		notifyChanged(SemanticsFeatureDescriptorEnum.identifier,
				this.identifier, this.identifier = identifier);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.expression,
				expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(SemanticsFeatureDescriptorEnum.expression,
				this.expression, this.expression = expression);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getIdentifier().wGetAdaptee(false);
		case 1:
			return getExpression().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIdentifier(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.BindingSubject));
			break;
		case 1:
			setExpression(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
