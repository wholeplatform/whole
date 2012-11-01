package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class StringLiteralAdapter extends AbstractEntityAdapter implements
		StringLiteral {
	private static final long serialVersionUID = 1;

	public StringLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public StringLiteralAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StringLiteral> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.StringLiteral;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
