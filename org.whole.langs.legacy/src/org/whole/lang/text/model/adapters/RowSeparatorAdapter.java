package org.whole.lang.text.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.text.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.text.visitors.ITextVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class RowSeparatorAdapter extends AbstractEntityAdapter implements
		RowSeparator {
	private static final long serialVersionUID = 1;

	public RowSeparatorAdapter(IEntity implementor) {
		super(implementor);
	}

	public RowSeparatorAdapter() {
	}

	public void accept(ITextVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<RowSeparator> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.RowSeparator;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
