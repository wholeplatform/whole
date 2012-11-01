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
public class TextSeparatorAdapter extends AbstractEntityAdapter implements
		TextSeparator {
	private static final long serialVersionUID = 1;

	public TextSeparatorAdapter(IEntity implementor) {
		super(implementor);
	}

	public TextSeparatorAdapter() {
	}

	public void accept(ITextVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TextSeparator> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.TextSeparator;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
