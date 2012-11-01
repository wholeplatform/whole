package org.whole.lang.scheme.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.scheme.reflect.SchemeFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class PairValueAdapter extends AbstractEntityAdapter implements
		PairValue {
	private static final long serialVersionUID = 1;

	public PairValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public PairValueAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PairValue> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.PairValue;
	}

	public ConstExpression getCar() {
		return wGet(SchemeFeatureDescriptorEnum.car).wGetAdapter(
				SchemeEntityDescriptorEnum.ConstExpression);
	}

	public void setCar(ConstExpression car) {
		wSet(SchemeFeatureDescriptorEnum.car, car);
	}

	public ConstExpression getCdr() {
		return wGet(SchemeFeatureDescriptorEnum.cdr).wGetAdapter(
				SchemeEntityDescriptorEnum.ConstExpression);
	}

	public void setCdr(ConstExpression cdr) {
		wSet(SchemeFeatureDescriptorEnum.cdr, cdr);
	}
}
