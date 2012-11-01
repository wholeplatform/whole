package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.model.PlacementEnum.Value;

/** 
 * @generator Whole
 */
public class PlacementAdapter extends AbstractEntityAdapter implements
		Placement {
	private static final long serialVersionUID = 1;

	public PlacementAdapter(IEntity implementor) {
		super(implementor);
	}

	public PlacementAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Placement> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.Placement;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
