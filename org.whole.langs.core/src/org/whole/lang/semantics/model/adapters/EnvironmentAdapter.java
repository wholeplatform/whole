package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EnvironmentAdapter extends AbstractEntityAdapter implements
		Environment {
	private static final long serialVersionUID = 1;

	public EnvironmentAdapter(IEntity implementor) {
		super(implementor);
	}

	public EnvironmentAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Environment> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.Environment;
	}
}
