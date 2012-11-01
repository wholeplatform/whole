package org.whole.lang.actions.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.actions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class IconAdapter extends AbstractEntityAdapter implements Icon {
	private static final long serialVersionUID = 1;

	public IconAdapter(IEntity implementor) {
		super(implementor);
	}

	public IconAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Icon> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.Icon;
	}

	public Object getValue() {
		return (Object) wGetValue();
	}

	public void setValue(Object value) {
		wSetValue((Object) value);
	}
}
