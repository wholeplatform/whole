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
public class CondExpressionImpl extends AbstractSimpleEntity implements
		CondExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CondExpression> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.CondExpression;
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.CondExpression_ord;
	}

	public void accept(ISchemeVisitor visitor) {
		visitor.visit(this);
	}

	private Branches branches;

	public Branches getBranches() {
		return notifyRequested(SchemeFeatureDescriptorEnum.branches, branches);
	}

	public void setBranches(Branches branches) {
		notifyChanged(SchemeFeatureDescriptorEnum.branches, this.branches,
				this.branches = branches);
	}

	private SchemeExpression elseBody;

	public SchemeExpression getElseBody() {
		return notifyRequested(SchemeFeatureDescriptorEnum.elseBody, elseBody);
	}

	public void setElseBody(SchemeExpression elseBody) {
		notifyChanged(SchemeFeatureDescriptorEnum.elseBody, this.elseBody,
				this.elseBody = elseBody);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getBranches().wGetAdaptee(false);
		case 1:
			return getElseBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setBranches(value.wGetAdapter(SchemeEntityDescriptorEnum.Branches));
			break;
		case 1:
			setElseBody(value
					.wGetAdapter(SchemeEntityDescriptorEnum.SchemeExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
