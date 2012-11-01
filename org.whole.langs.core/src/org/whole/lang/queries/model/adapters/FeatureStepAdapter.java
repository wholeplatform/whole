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
public class FeatureStepAdapter extends AbstractEntityAdapter implements
		FeatureStep {
	private static final long serialVersionUID = 1;

	public FeatureStepAdapter(IEntity implementor) {
		super(implementor);
	}

	public FeatureStepAdapter() {
	}

	public void accept(IQueriesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FeatureStep> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.FeatureStep;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
