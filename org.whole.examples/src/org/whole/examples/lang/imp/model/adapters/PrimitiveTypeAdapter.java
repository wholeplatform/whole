package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.model.PrimitiveTypeEnum.Value;

/** 
 * @generator Whole
 */
public class PrimitiveTypeAdapter extends AbstractEntityAdapter implements PrimitiveType {
	private static final long serialVersionUID = 1;

	public PrimitiveTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public PrimitiveTypeAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PrimitiveType> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.PrimitiveType;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
