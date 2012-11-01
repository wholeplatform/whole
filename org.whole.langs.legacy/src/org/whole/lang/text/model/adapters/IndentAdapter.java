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
public class IndentAdapter extends AbstractEntityAdapter implements Indent {
	private static final long serialVersionUID = 1;

	public IndentAdapter(IEntity implementor) {
		super(implementor);
	}

	public IndentAdapter() {
	}

	public void accept(ITextVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Indent> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.Indent;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
