package org.whole.lang.flowchart.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.flowchart.visitors.IFlowchartVisitor;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class TransitionsImpl extends
		AbstractCollectionCompositeEntity<Transition> implements Transitions {
	private static final long serialVersionUID = 1;

	public void accept(IFlowchartVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return FlowchartEntityDescriptorEnum.Transitions_ord;
	}

	public EntityDescriptor<Transitions> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.Transitions;
	}
}
