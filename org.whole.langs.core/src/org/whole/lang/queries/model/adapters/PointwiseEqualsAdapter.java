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
public class PointwiseEqualsAdapter extends AbstractEntityAdapter implements
		PointwiseEquals {
	private static final long serialVersionUID = 1;

	public PointwiseEqualsAdapter(IEntity implementor) {
		super(implementor);
	}

	public PointwiseEqualsAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PointwiseEquals> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.PointwiseEquals;
	}

	public PathExpression getPexp1() {
		return wGet(QueriesFeatureDescriptorEnum.pexp1).wGetAdapter(
				QueriesEntityDescriptorEnum.PathExpression);
	}

	public void setPexp1(PathExpression pexp1) {
		wSet(QueriesFeatureDescriptorEnum.pexp1, pexp1);
	}

	public PathExpression getPexp2() {
		return wGet(QueriesFeatureDescriptorEnum.pexp2).wGetAdapter(
				QueriesEntityDescriptorEnum.PathExpression);
	}

	public void setPexp2(PathExpression pexp2) {
		wSet(QueriesFeatureDescriptorEnum.pexp2, pexp2);
	}
}
