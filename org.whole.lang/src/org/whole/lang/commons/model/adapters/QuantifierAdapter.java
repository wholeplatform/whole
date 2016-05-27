package org.whole.lang.commons.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.commons.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.model.QuantifierEnum.Value;

/** 
 * @generator Whole
 */
public class QuantifierAdapter extends AbstractEntityAdapter implements Quantifier {
	private static final long serialVersionUID = 1;

	public QuantifierAdapter(IEntity implementor) {
		super(implementor);
	}

	public QuantifierAdapter() {
	}

	public void accept(ICommonsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Quantifier> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.Quantifier;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
