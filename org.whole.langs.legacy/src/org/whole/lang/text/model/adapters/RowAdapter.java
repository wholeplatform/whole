package org.whole.lang.text.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.text.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.text.visitors.ITextVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class RowAdapter extends AbstractListEntityAdapter<IText> implements Row {
	private static final long serialVersionUID = 1;

	public RowAdapter(IEntity implementor) {
		super(implementor);
	}

	public RowAdapter() {
	}

	public void accept(ITextVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Row> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.Row;
	}
}
