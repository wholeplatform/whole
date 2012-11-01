package org.whole.lang.testevents.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.testevents.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;
import org.whole.lang.testevents.reflect.TestEventsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class LabelsAdapter extends AbstractEntityAdapter implements Labels {
	private static final long serialVersionUID = 1;

	public LabelsAdapter(IEntity implementor) {
		super(implementor);
	}

	public LabelsAdapter() {
	}

	public void accept(ITestEventsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Labels> wGetEntityDescriptor() {
		return TestEventsEntityDescriptorEnum.Labels;
	}

	public Label getSimple() {
		return wGet(TestEventsFeatureDescriptorEnum.simple).wGetAdapter(
				TestEventsEntityDescriptorEnum.Label);
	}

	public void setSimple(Label simple) {
		wSet(TestEventsFeatureDescriptorEnum.simple, simple);
	}

	public Label getSimpleDerived() {
		return wGet(TestEventsFeatureDescriptorEnum.simpleDerived).wGetAdapter(
				TestEventsEntityDescriptorEnum.Label);
	}

	public void setSimpleDerived(Label simpleDerived) {
		wSet(TestEventsFeatureDescriptorEnum.simpleDerived, simpleDerived);
	}

	public Label getSimpleDerivedDerived() {
		return wGet(TestEventsFeatureDescriptorEnum.simpleDerivedDerived)
				.wGetAdapter(TestEventsEntityDescriptorEnum.Label);
	}

	public void setSimpleDerivedDerived(Label simpleDerivedDerived) {
		wSet(TestEventsFeatureDescriptorEnum.simpleDerivedDerived,
				simpleDerivedDerived);
	}
}
