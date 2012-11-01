package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.model.ArtifactsSynchronizeStrategyEnum.Value;

/** 
 * @generator Whole
 */
public class ArtifactsSynchronizeStrategyAdapter extends AbstractEntityAdapter
		implements ArtifactsSynchronizeStrategy {
	private static final long serialVersionUID = 1;

	public ArtifactsSynchronizeStrategyAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArtifactsSynchronizeStrategyAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArtifactsSynchronizeStrategy> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ArtifactsSynchronizeStrategy;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
