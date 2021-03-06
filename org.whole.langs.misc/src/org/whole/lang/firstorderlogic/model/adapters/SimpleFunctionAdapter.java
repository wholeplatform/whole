package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SimpleFunctionAdapter extends AbstractEntityAdapter implements
		SimpleFunction {
	private static final long serialVersionUID = 1;

	public SimpleFunctionAdapter(IEntity implementor) {
		super(implementor);
	}

	public SimpleFunctionAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SimpleFunction> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.SimpleFunction;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
