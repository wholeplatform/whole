package org.whole.lang.editors.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class RowElementAdapter extends AbstractEntityAdapter implements
		RowElement {
	private static final long serialVersionUID = 1;

	public RowElementAdapter(IEntity implementor) {
		super(implementor);
	}

	public RowElementAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<RowElement> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.RowElement;
	}
}
