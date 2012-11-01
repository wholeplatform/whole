package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.model.StageChangeEnum.Value;

/** 
 * @generator Whole
 */
public class StageChangeAdapter extends AbstractEntityAdapter implements
		StageChange {
	private static final long serialVersionUID = 1;

	public StageChangeAdapter(IEntity implementor) {
		super(implementor);
	}

	public StageChangeAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StageChange> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.StageChange;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
