package org.whole.lang.flowchart.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.flowchart.visitors.IFlowchartVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class NodesAdapter extends AbstractSetEntityAdapter<Node> implements
		Nodes {
	private static final long serialVersionUID = 1;

	public NodesAdapter(IEntity implementor) {
		super(implementor);
	}

	public NodesAdapter() {
	}

	public void accept(IFlowchartVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Nodes> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.Nodes;
	}
}
