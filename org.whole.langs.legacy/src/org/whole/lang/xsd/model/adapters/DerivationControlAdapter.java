package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.model.DerivationControlEnum.Value;

/** 
 * @generator Whole
 */
public class DerivationControlAdapter extends AbstractEntityAdapter implements
		DerivationControl {
	private static final long serialVersionUID = 1;

	public DerivationControlAdapter(IEntity implementor) {
		super(implementor);
	}

	public DerivationControlAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DerivationControl> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.DerivationControl;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
