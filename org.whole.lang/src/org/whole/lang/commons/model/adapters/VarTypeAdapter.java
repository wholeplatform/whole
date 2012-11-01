package org.whole.lang.commons.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.commons.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class VarTypeAdapter extends AbstractEntityAdapter implements VarType {
	private static final long serialVersionUID = 1;

	public VarTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public VarTypeAdapter() {
	}

	public void accept(ICommonsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VarType> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.VarType;
	}

	public EntityDescriptor getValue() {
		return (EntityDescriptor) wEnumValue();
	}

	public void setValue(EntityDescriptor value) {
		wSetValue((Object) value);
	}
}
