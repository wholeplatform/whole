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
public class ITextAdapter extends AbstractEntityAdapter implements IText {
	private static final long serialVersionUID = 1;

	public ITextAdapter(IEntity implementor) {
		super(implementor);
	}

	public ITextAdapter() {
	}

	public void accept(ITextVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IText> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.IText;
	}
}
