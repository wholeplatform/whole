package org.whole.lang.flowchart.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class FlowchartIdentitySwitchVisitor extends AbstractVisitor
		implements IFlowchartVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case FlowchartEntityDescriptorEnum.Flowchart_ord:
			visit((Flowchart) entity);
			break;
		case FlowchartEntityDescriptorEnum.Nodes_ord:
			visit((Nodes) entity);
			break;
		case FlowchartEntityDescriptorEnum.Transitions_ord:
			visit((Transitions) entity);
			break;
		case FlowchartEntityDescriptorEnum.SimpleTransition_ord:
			visit((SimpleTransition) entity);
			break;
		case FlowchartEntityDescriptorEnum.LabeledTransition_ord:
			visit((LabeledTransition) entity);
			break;
		case FlowchartEntityDescriptorEnum.Pixels_ord:
			visit((Pixels) entity);
			break;
		case FlowchartEntityDescriptorEnum.Text_ord:
			visit((Text) entity);
			break;
		case FlowchartEntityDescriptorEnum.Entry_ord:
			visit((Entry) entity);
			break;
		case FlowchartEntityDescriptorEnum.Exit_ord:
			visit((Exit) entity);
			break;
		case FlowchartEntityDescriptorEnum.Block_ord:
			visit((Block) entity);
			break;
		case FlowchartEntityDescriptorEnum.Choice_ord:
			visit((Choice) entity);
			break;
		case FlowchartEntityDescriptorEnum.Join_ord:
			visit((Join) entity);
			break;
		}
	}
}
