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
public class BranchImpl extends AbstractSimpleEntity implements Branch {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Branch> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.Branch;
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.Branch_ord;
	}

	public void accept(ISchemeVisitor visitor) {
		visitor.visit(this);
	}

	private SchemeExpression test;

	public SchemeExpression getTest() {
		return notifyRequested(SchemeFeatureDescriptorEnum.test, test);
	}

	public void setTest(SchemeExpression test) {
		notifyChanged(SchemeFeatureDescriptorEnum.test, this.test,
				this.test = test);
	}

	private SchemeExpression body;

	public SchemeExpression getBody() {
		return notifyRequested(SchemeFeatureDescriptorEnum.body, body);
	}

	public void setBody(SchemeExpression body) {
		notifyChanged(SchemeFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTest().wGetAdaptee(false);
		case 1:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTest(value
					.wGetAdapter(SchemeEntityDescriptorEnum.SchemeExpression));
			break;
		case 1:
			setBody(value
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
