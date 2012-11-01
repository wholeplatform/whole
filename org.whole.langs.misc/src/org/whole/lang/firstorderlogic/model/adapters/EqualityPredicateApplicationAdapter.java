package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class EqualityPredicateApplicationAdapter extends AbstractEntityAdapter
		implements EqualityPredicateApplication {
	private static final long serialVersionUID = 1;

	public EqualityPredicateApplicationAdapter(IEntity implementor) {
		super(implementor);
	}

	public EqualityPredicateApplicationAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EqualityPredicateApplication> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication;
	}

	public Term getLeftTerm() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.leftTerm).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Term);
	}

	public void setLeftTerm(Term leftTerm) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.leftTerm, leftTerm);
	}

	public Term getRightTerm() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.rightTerm)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Term);
	}

	public void setRightTerm(Term rightTerm) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.rightTerm, rightTerm);
	}
}
