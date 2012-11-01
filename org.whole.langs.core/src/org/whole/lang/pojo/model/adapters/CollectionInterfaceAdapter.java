package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.model.CollectionInterfaceEnum.Value;

/** 
 * @generator Whole
 */
public class CollectionInterfaceAdapter extends AbstractEntityAdapter implements
		CollectionInterface {
	private static final long serialVersionUID = 1;

	public CollectionInterfaceAdapter(IEntity implementor) {
		super(implementor);
	}

	public CollectionInterfaceAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CollectionInterface> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.CollectionInterface;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
