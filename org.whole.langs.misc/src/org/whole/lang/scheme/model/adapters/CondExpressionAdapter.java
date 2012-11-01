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
public class CondExpressionAdapter extends AbstractEntityAdapter implements
		CondExpression {
	private static final long serialVersionUID = 1;

	public CondExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public CondExpressionAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CondExpression> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.CondExpression;
	}

	public Branches getBranches() {
		return wGet(SchemeFeatureDescriptorEnum.branches).wGetAdapter(
				SchemeEntityDescriptorEnum.Branches);
	}

	public void setBranches(Branches branches) {
		wSet(SchemeFeatureDescriptorEnum.branches, branches);
	}

	public SchemeExpression getElseBody() {
		return wGet(SchemeFeatureDescriptorEnum.elseBody).wGetAdapter(
				SchemeEntityDescriptorEnum.SchemeExpression);
	}

	public void setElseBody(SchemeExpression elseBody) {
		wSet(SchemeFeatureDescriptorEnum.elseBody, elseBody);
	}
}
