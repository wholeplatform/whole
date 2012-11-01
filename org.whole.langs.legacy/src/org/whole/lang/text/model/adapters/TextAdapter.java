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
public class TextAdapter extends AbstractEntityAdapter implements Text {
	private static final long serialVersionUID = 1;

	public TextAdapter(IEntity implementor) {
		super(implementor);
	}

	public TextAdapter() {
	}

	public void accept(ITextVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Text> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.Text;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
