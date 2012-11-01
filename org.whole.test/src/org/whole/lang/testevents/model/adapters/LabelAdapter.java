package org.whole.lang.testevents.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.testevents.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class LabelAdapter extends AbstractEntityAdapter implements Label {
	private static final long serialVersionUID = 1;

	public LabelAdapter(IEntity implementor) {
		super(implementor);
	}

	public LabelAdapter() {
	}

	public void accept(ITestEventsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Label> wGetEntityDescriptor() {
		return TestEventsEntityDescriptorEnum.Label;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
