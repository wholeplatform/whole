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
public class PredicateApplicationAdapter extends AbstractEntityAdapter
		implements PredicateApplication {
	private static final long serialVersionUID = 1;

	public PredicateApplicationAdapter(IEntity implementor) {
		super(implementor);
	}

	public PredicateApplicationAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PredicateApplication> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.PredicateApplication;
	}

	public Predicate getPredicate() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.predicate)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Predicate);
	}

	public void setPredicate(Predicate predicate) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.predicate, predicate);
	}

	public Arguments getArguments() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.arguments)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Arguments);
	}

	public void setArguments(Arguments arguments) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.arguments, arguments);
	}
}
