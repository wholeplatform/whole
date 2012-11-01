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
public class ImplicationAdapter extends AbstractEntityAdapter implements
		Implication {
	private static final long serialVersionUID = 1;

	public ImplicationAdapter(IEntity implementor) {
		super(implementor);
	}

	public ImplicationAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Implication> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Implication;
	}

	public Formula getAntecedent() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.antecedent)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Formula);
	}

	public void setAntecedent(Formula antecedent) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.antecedent, antecedent);
	}

	public Formula getConsequent() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.consequent)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Formula);
	}

	public void setConsequent(Formula consequent) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.consequent, consequent);
	}
}
