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
public class LabeledTransitionImpl extends AbstractSimpleEntity implements
		LabeledTransition {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LabeledTransition> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.LabeledTransition;
	}

	public int wGetEntityOrd() {
		return FlowchartEntityDescriptorEnum.LabeledTransition_ord;
	}

	public void accept(IFlowchartVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Text label;

	public Text getLabel() {
		return notifyRequested(FlowchartFeatureDescriptorEnum.label, label);
	}

	public void setLabel(Text label) {
		notifyChanged(FlowchartFeatureDescriptorEnum.label, this.label,
				this.label = label);
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
			return getLabel().wGetAdaptee(false);
		case 1:
			return getSource().wGetAdaptee(false);
		case 2:
			return getTarget().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLabel(value.wGetAdapter(FlowchartEntityDescriptorEnum.Text));
			break;
		case 1:
			setSource(value.wGetAdapter(FlowchartEntityDescriptorEnum.Node));
			break;
		case 2:
			setTarget(value.wGetAdapter(FlowchartEntityDescriptorEnum.Node));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}

	public int wAdjacentSize() {
		return 2;
	}
}
