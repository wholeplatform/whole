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
public class QualifiedPredicateAdapter extends AbstractEntityAdapter implements
		QualifiedPredicate {
	private static final long serialVersionUID = 1;

	public QualifiedPredicateAdapter(IEntity implementor) {
		super(implementor);
	}

	public QualifiedPredicateAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<QualifiedPredicate> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate;
	}

	public Name getTheoryAlias() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.theoryAlias)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setTheoryAlias(Name theoryAlias) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.theoryAlias, theoryAlias);
	}

	public SimplePredicate getName() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.name).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.SimplePredicate);
	}

	public void setName(SimplePredicate name) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.name, name);
	}
}
