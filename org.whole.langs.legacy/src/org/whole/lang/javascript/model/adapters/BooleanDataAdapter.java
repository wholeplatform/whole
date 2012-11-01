package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class BooleanDataAdapter extends AbstractEntityAdapter implements
		BooleanData {
	private static final long serialVersionUID = 1;

	public BooleanDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public BooleanDataAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BooleanData> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.BooleanData;
	}

	public boolean isValue() {
		return wBooleanValue();
	}

	public void setValue(boolean value) {
		wSetValue(value);
	}
}
