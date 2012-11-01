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
public class SimpleTransitionAdapter extends AbstractEntityAdapter implements
		SimpleTransition {
	private static final long serialVersionUID = 1;

	public SimpleTransitionAdapter(IEntity implementor) {
		super(implementor);
	}

	public SimpleTransitionAdapter() {
	}

	public void accept(IFlowchartVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SimpleTransition> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.SimpleTransition;
	}

	public Node getSource() {
		return wGet(FlowchartFeatureDescriptorEnum.source).wGetAdapter(
				FlowchartEntityDescriptorEnum.Node);
	}

	public void setSource(Node source) {
		wSet(FlowchartFeatureDescriptorEnum.source, source);
	}

	public Node getTarget() {
		return wGet(FlowchartFeatureDescriptorEnum.target).wGetAdapter(
				FlowchartEntityDescriptorEnum.Node);
	}

	public void setTarget(Node target) {
		wSet(FlowchartFeatureDescriptorEnum.target, target);
	}
}
