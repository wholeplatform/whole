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
public class IRowAdapter extends AbstractEntityAdapter implements IRow {
	private static final long serialVersionUID = 1;

	public IRowAdapter(IEntity implementor) {
		super(implementor);
	}

	public IRowAdapter() {
	}

	public void accept(ITextVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IRow> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.IRow;
	}
}
