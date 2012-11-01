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
public class TypeCastImpl extends AbstractSimpleEntity implements TypeCast {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TypeCast> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.TypeCast;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.TypeCast_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private EntityType type;

	public EntityType getType() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.type, type);
	}

	public void setType(EntityType type) {
		notifyChanged(SemanticsFeatureDescriptorEnum.type, this.type,
				this.type = type);
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
			return getType().wGetAdaptee(false);
		case 1:
			return getExpression().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setType(value.wGetAdapter(SemanticsEntityDescriptorEnum.EntityType));
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
