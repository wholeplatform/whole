package org.whole.lang.flowchart.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.flowchart.reflect.FlowchartFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FlowchartGenericBuilderAdapter extends GenericIdentityBuilder {
	private IFlowchartBuilder specificBuilder;

	public FlowchartGenericBuilderAdapter(IFlowchartBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public FlowchartGenericBuilderAdapter(IFlowchartBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case FlowchartFeatureDescriptorEnum.nodes_ord:
			specificBuilder.nodes();
			break;
		case FlowchartFeatureDescriptorEnum.transitions_ord:
			specificBuilder.transitions();
			break;
		case FlowchartFeatureDescriptorEnum.source_ord:
			specificBuilder.source();
			break;
		case FlowchartFeatureDescriptorEnum.target_ord:
			specificBuilder.target();
			break;
		case FlowchartFeatureDescriptorEnum.label_ord:
			specificBuilder.label();
			break;
		case FlowchartFeatureDescriptorEnum.x_ord:
			specificBuilder.x();
			break;
		case FlowchartFeatureDescriptorEnum.y_ord:
			specificBuilder.y();
			break;
		case FlowchartFeatureDescriptorEnum.width_ord:
			specificBuilder.width();
			break;
		case FlowchartFeatureDescriptorEnum.height_ord:
			specificBuilder.height();
			break;
		case FlowchartFeatureDescriptorEnum.description_ord:
			specificBuilder.description();
			break;
		case FlowchartFeatureDescriptorEnum.sourceTransition_ord:
			specificBuilder.sourceTransition();
			break;
		case FlowchartFeatureDescriptorEnum.targetTransition_ord:
			specificBuilder.targetTransition();
			break;
		case FlowchartFeatureDescriptorEnum.trueSourceTransition_ord:
			specificBuilder.trueSourceTransition();
			break;
		case FlowchartFeatureDescriptorEnum.falseSourceTransition_ord:
			specificBuilder.falseSourceTransition();
			break;
		case FlowchartFeatureDescriptorEnum.targetTransitions_ord:
			specificBuilder.targetTransitions();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case FlowchartEntityDescriptorEnum.Flowchart_ord:
			specificBuilder.Flowchart();
			break;
		case FlowchartEntityDescriptorEnum.Nodes_ord:
			specificBuilder.Nodes();
			break;
		case FlowchartEntityDescriptorEnum.Transitions_ord:
			specificBuilder.Transitions();
			break;
		case FlowchartEntityDescriptorEnum.SimpleTransition_ord:
			specificBuilder.SimpleTransition();
			break;
		case FlowchartEntityDescriptorEnum.LabeledTransition_ord:
			specificBuilder.LabeledTransition();
			break;
		case FlowchartEntityDescriptorEnum.Entry_ord:
			specificBuilder.Entry();
			break;
		case FlowchartEntityDescriptorEnum.Exit_ord:
			specificBuilder.Exit();
			break;
		case FlowchartEntityDescriptorEnum.Block_ord:
			specificBuilder.Block();
			break;
		case FlowchartEntityDescriptorEnum.Choice_ord:
			specificBuilder.Choice();
			break;
		case FlowchartEntityDescriptorEnum.Join_ord:
			specificBuilder.Join();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case FlowchartEntityDescriptorEnum.Flowchart_ord:
			specificBuilder.Flowchart_();
			break;
		case FlowchartEntityDescriptorEnum.Nodes_ord:
			specificBuilder.Nodes_();
			break;
		case FlowchartEntityDescriptorEnum.Transitions_ord:
			specificBuilder.Transitions_();
			break;
		case FlowchartEntityDescriptorEnum.SimpleTransition_ord:
			specificBuilder.SimpleTransition_();
			break;
		case FlowchartEntityDescriptorEnum.LabeledTransition_ord:
			specificBuilder.LabeledTransition_();
			break;
		case FlowchartEntityDescriptorEnum.Entry_ord:
			specificBuilder.Entry_();
			break;
		case FlowchartEntityDescriptorEnum.Exit_ord:
			specificBuilder.Exit_();
			break;
		case FlowchartEntityDescriptorEnum.Block_ord:
			specificBuilder.Block_();
			break;
		case FlowchartEntityDescriptorEnum.Choice_ord:
			specificBuilder.Choice_();
			break;
		case FlowchartEntityDescriptorEnum.Join_ord:
			specificBuilder.Join_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case FlowchartEntityDescriptorEnum.Flowchart_ord:
			specificBuilder._Flowchart();
			break;
		case FlowchartEntityDescriptorEnum.Nodes_ord:
			specificBuilder._Nodes();
			break;
		case FlowchartEntityDescriptorEnum.Transitions_ord:
			specificBuilder._Transitions();
			break;
		case FlowchartEntityDescriptorEnum.SimpleTransition_ord:
			specificBuilder._SimpleTransition();
			break;
		case FlowchartEntityDescriptorEnum.LabeledTransition_ord:
			specificBuilder._LabeledTransition();
			break;
		case FlowchartEntityDescriptorEnum.Entry_ord:
			specificBuilder._Entry();
			break;
		case FlowchartEntityDescriptorEnum.Exit_ord:
			specificBuilder._Exit();
			break;
		case FlowchartEntityDescriptorEnum.Block_ord:
			specificBuilder._Block();
			break;
		case FlowchartEntityDescriptorEnum.Choice_ord:
			specificBuilder._Choice();
			break;
		case FlowchartEntityDescriptorEnum.Join_ord:
			specificBuilder._Join();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case FlowchartEntityDescriptorEnum.Nodes_ord:
			specificBuilder.Nodes_(initialCapacity);
			break;
		case FlowchartEntityDescriptorEnum.Transitions_ord:
			specificBuilder.Transitions_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case FlowchartEntityDescriptorEnum.Pixels_ord:
			specificBuilder.Pixels(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case FlowchartEntityDescriptorEnum.Text_ord:
			specificBuilder.Text(value);
			break;
		}
	}
}
