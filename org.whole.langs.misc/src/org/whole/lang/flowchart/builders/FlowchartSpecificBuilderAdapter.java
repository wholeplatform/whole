package org.whole.lang.flowchart.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.flowchart.reflect.FlowchartFeatureDescriptorEnum;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FlowchartSpecificBuilderAdapter extends GenericBuilderContext
		implements IFlowchartBuilder {
	public FlowchartSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public FlowchartSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void targetTransitions() {
		wFeature(FlowchartFeatureDescriptorEnum.targetTransitions);
	}

	public void falseSourceTransition() {
		wFeature(FlowchartFeatureDescriptorEnum.falseSourceTransition);
	}

	public void trueSourceTransition() {
		wFeature(FlowchartFeatureDescriptorEnum.trueSourceTransition);
	}

	public void targetTransition() {
		wFeature(FlowchartFeatureDescriptorEnum.targetTransition);
	}

	public void sourceTransition() {
		wFeature(FlowchartFeatureDescriptorEnum.sourceTransition);
	}

	public void description() {
		wFeature(FlowchartFeatureDescriptorEnum.description);
	}

	public void height() {
		wFeature(FlowchartFeatureDescriptorEnum.height);
	}

	public void width() {
		wFeature(FlowchartFeatureDescriptorEnum.width);
	}

	public void y() {
		wFeature(FlowchartFeatureDescriptorEnum.y);
	}

	public void x() {
		wFeature(FlowchartFeatureDescriptorEnum.x);
	}

	public void label() {
		wFeature(FlowchartFeatureDescriptorEnum.label);
	}

	public void target() {
		wFeature(FlowchartFeatureDescriptorEnum.target);
	}

	public void source() {
		wFeature(FlowchartFeatureDescriptorEnum.source);
	}

	public void transitions() {
		wFeature(FlowchartFeatureDescriptorEnum.transitions);
	}

	public void nodes() {
		wFeature(FlowchartFeatureDescriptorEnum.nodes);
	}

	public void visit() {
	}

	public void Flowchart() {
		wEntity(FlowchartEntityDescriptorEnum.Flowchart);
	}

	public void Flowchart_() {
		wEntity_(FlowchartEntityDescriptorEnum.Flowchart);
	}

	public void _Flowchart() {
		_wEntity(FlowchartEntityDescriptorEnum.Flowchart);
	}

	public void Nodes() {
		wEntity(FlowchartEntityDescriptorEnum.Nodes);
	}

	public void Nodes_() {
		wEntity_(FlowchartEntityDescriptorEnum.Nodes);
	}

	public void Nodes_(int initialCapacity) {
		wEntity_(FlowchartEntityDescriptorEnum.Nodes, initialCapacity);
	}

	public void _Nodes() {
		_wEntity(FlowchartEntityDescriptorEnum.Nodes);
	}

	public void Transitions() {
		wEntity(FlowchartEntityDescriptorEnum.Transitions);
	}

	public void Transitions_() {
		wEntity_(FlowchartEntityDescriptorEnum.Transitions);
	}

	public void Transitions_(int initialCapacity) {
		wEntity_(FlowchartEntityDescriptorEnum.Transitions, initialCapacity);
	}

	public void _Transitions() {
		_wEntity(FlowchartEntityDescriptorEnum.Transitions);
	}

	public void SimpleTransition() {
		wEntity(FlowchartEntityDescriptorEnum.SimpleTransition);
	}

	public void SimpleTransition_() {
		wEntity_(FlowchartEntityDescriptorEnum.SimpleTransition);
	}

	public void _SimpleTransition() {
		_wEntity(FlowchartEntityDescriptorEnum.SimpleTransition);
	}

	public void LabeledTransition() {
		wEntity(FlowchartEntityDescriptorEnum.LabeledTransition);
	}

	public void LabeledTransition_() {
		wEntity_(FlowchartEntityDescriptorEnum.LabeledTransition);
	}

	public void _LabeledTransition() {
		_wEntity(FlowchartEntityDescriptorEnum.LabeledTransition);
	}

	public void Pixels() {
		wEntity(FlowchartEntityDescriptorEnum.Pixels);
	}

	public void Pixels(int value) {
		wEntity(FlowchartEntityDescriptorEnum.Pixels, value);
	}

	public void Text() {
		wEntity(FlowchartEntityDescriptorEnum.Text);
	}

	public void Text(String value) {
		wEntity(FlowchartEntityDescriptorEnum.Text, value);
	}

	public void Entry() {
		wEntity(FlowchartEntityDescriptorEnum.Entry);
	}

	public void Entry_() {
		wEntity_(FlowchartEntityDescriptorEnum.Entry);
	}

	public void _Entry() {
		_wEntity(FlowchartEntityDescriptorEnum.Entry);
	}

	public void Exit() {
		wEntity(FlowchartEntityDescriptorEnum.Exit);
	}

	public void Exit_() {
		wEntity_(FlowchartEntityDescriptorEnum.Exit);
	}

	public void _Exit() {
		_wEntity(FlowchartEntityDescriptorEnum.Exit);
	}

	public void Block() {
		wEntity(FlowchartEntityDescriptorEnum.Block);
	}

	public void Block_() {
		wEntity_(FlowchartEntityDescriptorEnum.Block);
	}

	public void _Block() {
		_wEntity(FlowchartEntityDescriptorEnum.Block);
	}

	public void Choice() {
		wEntity(FlowchartEntityDescriptorEnum.Choice);
	}

	public void Choice_() {
		wEntity_(FlowchartEntityDescriptorEnum.Choice);
	}

	public void _Choice() {
		_wEntity(FlowchartEntityDescriptorEnum.Choice);
	}

	public void Join() {
		wEntity(FlowchartEntityDescriptorEnum.Join);
	}

	public void Join_() {
		wEntity_(FlowchartEntityDescriptorEnum.Join);
	}

	public void _Join() {
		_wEntity(FlowchartEntityDescriptorEnum.Join);
	}
}
