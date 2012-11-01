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
public class PartNameAdapter extends AbstractEntityAdapter implements PartName {
	private static final long serialVersionUID = 1;

	public PartNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public PartNameAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PartName> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.PartName;
	}
}
