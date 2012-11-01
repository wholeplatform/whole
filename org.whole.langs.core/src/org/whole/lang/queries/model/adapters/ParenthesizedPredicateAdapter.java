package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ParenthesizedPredicateAdapter extends AbstractEntityAdapter
		implements ParenthesizedPredicate {
	private static final long serialVersionUID = 1;

	public ParenthesizedPredicateAdapter(IEntity implementor) {
		super(implementor);
	}

	public ParenthesizedPredicateAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ParenthesizedPredicate> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.ParenthesizedPredicate;
	}

	public Predicate getPredicate() {
		return wGet(QueriesFeatureDescriptorEnum.predicate).wGetAdapter(
				QueriesEntityDescriptorEnum.Predicate);
	}

	public void setPredicate(Predicate predicate) {
		wSet(QueriesFeatureDescriptorEnum.predicate, predicate);
	}
}
