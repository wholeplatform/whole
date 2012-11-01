package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ExtraDimensionsAdapter extends AbstractEntityAdapter implements
		ExtraDimensions {
	private static final long serialVersionUID = 1;

	public ExtraDimensionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ExtraDimensionsAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ExtraDimensions> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ExtraDimensions;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
