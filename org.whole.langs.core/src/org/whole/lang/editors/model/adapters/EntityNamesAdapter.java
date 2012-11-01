package org.whole.lang.editors.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EntityNamesAdapter extends AbstractSetEntityAdapter<EntityName>
		implements EntityNames {
	private static final long serialVersionUID = 1;

	public EntityNamesAdapter(IEntity implementor) {
		super(implementor);
	}

	public EntityNamesAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EntityNames> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.EntityNames;
	}
}
