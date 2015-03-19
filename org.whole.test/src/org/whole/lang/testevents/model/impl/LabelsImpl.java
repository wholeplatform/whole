package org.whole.lang.testevents.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.testevents.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;
import org.whole.lang.testevents.reflect.TestEventsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class LabelsImpl extends AbstractSimpleEntity implements Labels {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Labels> wGetEntityDescriptor() {
		return TestEventsEntityDescriptorEnum.Labels;
	}

	public int wGetEntityOrd() {
		return TestEventsEntityDescriptorEnum.Labels_ord;
	}

	public void accept(ITestEventsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Label simple;

	public Label getSimple() {
		return notifyRequested(TestEventsFeatureDescriptorEnum.simple, simple);
	}

	public void setSimple(Label simple) {
		notifyChanged(TestEventsFeatureDescriptorEnum.simple, this.simple,
				this.simple = simple);
	}

	private Label simpleDerived;

	public Label getSimpleDerived() {
		return notifyRequested(TestEventsFeatureDescriptorEnum.simpleDerived,
				simpleDerived);
	}

	public void setSimpleDerived(Label simpleDerived) {
		notifyChanged(TestEventsFeatureDescriptorEnum.simpleDerived,
				this.simpleDerived, this.simpleDerived = simpleDerived);
	}

	private Label simpleDerivedDerived;

	public Label getSimpleDerivedDerived() {
		return notifyRequested(
				TestEventsFeatureDescriptorEnum.simpleDerivedDerived,
				simpleDerivedDerived);
	}

	public void setSimpleDerivedDerived(Label simpleDerivedDerived) {
		notifyChanged(TestEventsFeatureDescriptorEnum.simpleDerivedDerived,
				this.simpleDerivedDerived,
				this.simpleDerivedDerived = simpleDerivedDerived);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSimple().wGetAdaptee(false);
		case 1:
			return getSimpleDerived().wGetAdaptee(false);
		case 2:
			return getSimpleDerivedDerived().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSimple(value.wGetAdapter(TestEventsEntityDescriptorEnum.Label));
			break;
		case 1:
			setSimpleDerived(value
					.wGetAdapter(TestEventsEntityDescriptorEnum.Label));
			break;
		case 2:
			setSimpleDerivedDerived(value
					.wGetAdapter(TestEventsEntityDescriptorEnum.Label));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
