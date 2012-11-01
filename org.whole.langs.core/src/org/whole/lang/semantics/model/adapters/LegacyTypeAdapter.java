package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.model.LegacyTypeEnum.Value;

/** 
 * @generator Whole
 */
public class LegacyTypeAdapter extends AbstractEntityAdapter implements
		LegacyType {
	private static final long serialVersionUID = 1;

	public LegacyTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public LegacyTypeAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LegacyType> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.LegacyType;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
