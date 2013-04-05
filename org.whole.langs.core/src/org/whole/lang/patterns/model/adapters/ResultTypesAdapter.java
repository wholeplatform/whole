package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ResultTypesAdapter extends AbstractListEntityAdapter<ResultType>
		implements ResultTypes {
	private static final long serialVersionUID = 1;

	public ResultTypesAdapter(IEntity implementor) {
		super(implementor);
	}

	public ResultTypesAdapter() {
	}

	public void accept(IPatternsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ResultTypes> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.ResultTypes;
	}
}
