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
public class StringDataAdapter extends AbstractEntityAdapter implements
		StringData {
	private static final long serialVersionUID = 1;

	public StringDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public StringDataAdapter() {
	}

	public void accept(IEnvironmentVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StringData> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.StringData;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
