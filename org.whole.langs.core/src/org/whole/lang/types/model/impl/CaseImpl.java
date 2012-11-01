package org.whole.lang.types.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.types.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CaseImpl extends AbstractSimpleEntity implements Case {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Case> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.Case;
	}

	public int wGetEntityOrd() {
		return TypesEntityDescriptorEnum.Case_ord;
	}

	public void accept(ITypesVisitor visitor) {
		visitor.visit(this);
	}

	private BasicType type;

	public BasicType getType() {
		return notifyRequested(TypesFeatureDescriptorEnum.type, type);
	}

	public void setType(BasicType type) {
		notifyChanged(TypesFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	private Expressions expressions;

	public Expressions getExpressions() {
		return notifyRequested(TypesFeatureDescriptorEnum.expressions,
				expressions);
	}

	public void setExpressions(Expressions expressions) {
		notifyChanged(TypesFeatureDescriptorEnum.expressions, this.expressions,
				this.expressions = expressions);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getType().wGetAdaptee(false);
		case 1:
			return getExpressions().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setType(value.wGetAdapter(TypesEntityDescriptorEnum.BasicType));
			break;
		case 1:
			setExpressions(value
					.wGetAdapter(TypesEntityDescriptorEnum.Expressions));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
