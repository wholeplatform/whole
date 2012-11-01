package org.whole.lang.environment.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.environment.model.*;
import org.whole.lang.environment.model.Void;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class VoidAdapter extends AbstractEntityAdapter implements Void {
	private static final long serialVersionUID = 1;

	public VoidAdapter(IEntity implementor) {
		super(implementor);
	}

	public VoidAdapter() {
	}

	public void accept(IEnvironmentVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Void> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.Void;
	}
}
