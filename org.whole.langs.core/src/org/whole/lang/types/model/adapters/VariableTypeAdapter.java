package org.whole.lang.types.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class VariableTypeAdapter extends AbstractEntityAdapter implements
		VariableType {
	private static final long serialVersionUID = 1;

	public VariableTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableTypeAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableType> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.VariableType;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
