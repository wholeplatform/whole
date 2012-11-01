package org.whole.lang.flowchart.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.flowchart.visitors.IFlowchartVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;
import org.whole.lang.flowchart.reflect.FlowchartFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FlowchartAdapter extends AbstractEntityAdapter implements
		Flowchart {
	private static final long serialVersionUID = 1;

	public FlowchartAdapter(IEntity implementor) {
		super(implementor);
	}

	public FlowchartAdapter() {
	}

	public void accept(IFlowchartVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Flowchart> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.Flowchart;
	}

	public Nodes getNodes() {
		return wGet(FlowchartFeatureDescriptorEnum.nodes).wGetAdapter(
				FlowchartEntityDescriptorEnum.Nodes);
	}

	public void setNodes(Nodes nodes) {
		wSet(FlowchartFeatureDescriptorEnum.nodes, nodes);
	}

	public Transitions getTransitions() {
		return wGet(FlowchartFeatureDescriptorEnum.transitions).wGetAdapter(
				FlowchartEntityDescriptorEnum.Transitions);
	}

	public void setTransitions(Transitions transitions) {
		wSet(FlowchartFeatureDescriptorEnum.transitions, transitions);
	}
}
