package org.whole.lang.flowchart.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;
import org.whole.lang.flowchart.visitors.IFlowchartVisitor;
import org.whole.lang.flowchart.reflect.FlowchartFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FlowchartImpl extends AbstractSimpleEntity implements Flowchart {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Flowchart> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.Flowchart;
	}

	public int wGetEntityOrd() {
		return FlowchartEntityDescriptorEnum.Flowchart_ord;
	}

	public void accept(IFlowchartVisitor visitor) {
		visitor.visit(this);
	}

	private Nodes nodes;

	public Nodes getNodes() {
		return notifyRequested(FlowchartFeatureDescriptorEnum.nodes, nodes);
	}

	public void setNodes(Nodes nodes) {
		notifyChanged(FlowchartFeatureDescriptorEnum.nodes, this.nodes,
				this.nodes = nodes);
	}

	private Transitions transitions;

	public Transitions getTransitions() {
		return notifyRequested(FlowchartFeatureDescriptorEnum.transitions,
				transitions);
	}

	public void setTransitions(Transitions transitions) {
		notifyChanged(FlowchartFeatureDescriptorEnum.transitions,
				this.transitions, this.transitions = transitions);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getNodes().wGetAdaptee(false);
		case 1:
			return getTransitions().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setNodes(value.wGetAdapter(FlowchartEntityDescriptorEnum.Nodes));
			break;
		case 1:
			setTransitions(value
					.wGetAdapter(FlowchartEntityDescriptorEnum.Transitions));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
