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
public class CharDataAdapter extends AbstractEntityAdapter implements CharData {
	private static final long serialVersionUID = 1;

	public CharDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public CharDataAdapter() {
	}

	public void accept(IEnvironmentVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CharData> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.CharData;
	}

	public char getValue() {
		return wCharValue();
	}

	public void setValue(char value) {
		wSetValue(value);
	}
}
