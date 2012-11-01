package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.model.ArtifactsTraversalStrategyEnum.Value;

/** 
 * @generator Whole
 */
public class ArtifactsTraversalStrategyAdapter extends AbstractEntityAdapter
		implements ArtifactsTraversalStrategy {
	private static final long serialVersionUID = 1;

	public ArtifactsTraversalStrategyAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArtifactsTraversalStrategyAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArtifactsTraversalStrategy> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ArtifactsTraversalStrategy;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
