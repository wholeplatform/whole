package org.whole.lang.flowchart.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.flowchart.visitors.IFlowchartVisitor;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class NodesImpl extends AbstractCollectionCompositeEntity<Node>
		implements Nodes {
	private static final long serialVersionUID = 1;

	public void accept(IFlowchartVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FlowchartEntityDescriptorEnum.Nodes_ord;
	}

	public EntityDescriptor<Nodes> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.Nodes;
	}
}
