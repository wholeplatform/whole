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
public class FragmentRootStepAdapter extends AbstractEntityAdapter implements
		FragmentRootStep {
	private static final long serialVersionUID = 1;

	public FragmentRootStepAdapter(IEntity implementor) {
		super(implementor);
	}

	public FragmentRootStepAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FragmentRootStep> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.FragmentRootStep;
	}
}
