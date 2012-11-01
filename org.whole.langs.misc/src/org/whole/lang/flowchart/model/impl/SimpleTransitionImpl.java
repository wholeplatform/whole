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
public class SimpleTransitionImpl extends AbstractSimpleEntity implements
		SimpleTransition {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SimpleTransition> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.SimpleTransition;
	}

	public int wGetEntityOrd() {
		return FlowchartEntityDescriptorEnum.SimpleTransition_ord;
	}

	public void accept(IFlowchartVisitor visitor) {
		visitor.visit(this);
	}

	private Node source;

	public Node getSource() {
		return notifyRequested(FlowchartFeatureDescriptorEnum.source, source);
	}

	public void setSource(Node source) {
		notifyChanged(FlowchartFeatureDescriptorEnum.source, this.source,
				this.source = source, false);
	}

	private Node target;

	public Node getTarget() {
		return notifyRequested(FlowchartFeatureDescriptorEnum.target, target);
	}

	public void setTarget(Node target) {
		notifyChanged(FlowchartFeatureDescriptorEnum.target, this.target,
				this.target = target, false);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSource().wGetAdaptee(false);
		case 1:
			return getTarget().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSource(value.wGetAdapter(FlowchartEntityDescriptorEnum.Node));
			break;
		case 1:
			setTarget(value.wGetAdapter(FlowchartEntityDescriptorEnum.Node));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wAdjacentSize() {
		return 2;
	}
}
