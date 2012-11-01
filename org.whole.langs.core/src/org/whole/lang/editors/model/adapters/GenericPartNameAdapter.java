package org.whole.lang.editors.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.editors.model.GenericPartNameEnum.Value;

/** 
 * @generator Whole
 */
public class GenericPartNameAdapter extends AbstractEntityAdapter implements
		GenericPartName {
	private static final long serialVersionUID = 1;

	public GenericPartNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public GenericPartNameAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<GenericPartName> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.GenericPartName;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
