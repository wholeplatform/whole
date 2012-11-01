package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DirectStepAdapter extends AbstractEntityAdapter implements
		DirectStep {
	private static final long serialVersionUID = 1;

	public DirectStepAdapter(IEntity implementor) {
		super(implementor);
	}

	public DirectStepAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DirectStep> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.DirectStep;
	}
}
