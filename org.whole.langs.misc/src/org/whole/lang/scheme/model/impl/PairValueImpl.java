package org.whole.lang.scheme.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.scheme.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.scheme.reflect.SchemeFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PairValueImpl extends AbstractSimpleEntity implements PairValue {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PairValue> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.PairValue;
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.PairValue_ord;
	}

	public void accept(ISchemeVisitor visitor) {
		visitor.visit(this);
	}

	private ConstExpression car;

	public ConstExpression getCar() {
		return notifyRequested(SchemeFeatureDescriptorEnum.car, car);
	}

	public void setCar(ConstExpression car) {
		notifyChanged(SchemeFeatureDescriptorEnum.car, this.car, this.car = car);
	}

	private ConstExpression cdr;

	public ConstExpression getCdr() {
		return notifyRequested(SchemeFeatureDescriptorEnum.cdr, cdr);
	}

	public void setCdr(ConstExpression cdr) {
		notifyChanged(SchemeFeatureDescriptorEnum.cdr, this.cdr, this.cdr = cdr);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getCar().wGetAdaptee(false);
		case 1:
			return getCdr().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setCar(value
					.wGetAdapter(SchemeEntityDescriptorEnum.ConstExpression));
			break;
		case 1:
			setCdr(value
					.wGetAdapter(SchemeEntityDescriptorEnum.ConstExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
