package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class BooleanDataAdapter extends AbstractEntityAdapter implements
		BooleanData {
	private static final long serialVersionUID = 1;

	public BooleanDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public BooleanDataAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BooleanData> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.BooleanData;
	}

	public boolean isValue() {
		return wBooleanValue();
	}

	public void setValue(boolean value) {
		wSetValue(value);
	}
}
