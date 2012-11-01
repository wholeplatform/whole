package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EnvironmentsAdapter extends AbstractListEntityAdapter<Environment>
		implements Environments {
	private static final long serialVersionUID = 1;

	public EnvironmentsAdapter(IEntity implementor) {
		super(implementor);
	}

	public EnvironmentsAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Environments> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.Environments;
	}
}
