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
public class TransitionsAdapter extends AbstractSetEntityAdapter<Transition>
		implements Transitions {
	private static final long serialVersionUID = 1;

	public TransitionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public TransitionsAdapter() {
	}

	public void accept(IFlowchartVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Transitions> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.Transitions;
	}
}
