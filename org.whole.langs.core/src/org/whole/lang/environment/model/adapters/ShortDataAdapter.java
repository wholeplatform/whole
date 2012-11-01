package org.whole.lang.environment.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.environment.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ShortDataAdapter extends AbstractEntityAdapter implements
		ShortData {
	private static final long serialVersionUID = 1;

	public ShortDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public ShortDataAdapter() {
	}

	public void accept(IEnvironmentVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ShortData> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.ShortData;
	}

	public short getValue() {
		return wShortValue();
	}

	public void setValue(short value) {
		wSetValue(value);
	}
}
