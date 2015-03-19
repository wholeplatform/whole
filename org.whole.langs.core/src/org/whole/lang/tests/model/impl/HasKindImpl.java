package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class HasKindImpl extends AbstractSimpleEntity implements HasKind {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<HasKind> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.HasKind;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.HasKind_ord;
	}

	public void accept(ITestsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Kind kind;

	public Kind getKind() {
		return notifyRequested(TestsFeatureDescriptorEnum.kind, kind);
	}

	public void setKind(Kind kind) {
		notifyChanged(TestsFeatureDescriptorEnum.kind, this.kind,
				this.kind = kind);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getKind().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setKind(value.wGetAdapter(TestsEntityDescriptorEnum.Kind));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
