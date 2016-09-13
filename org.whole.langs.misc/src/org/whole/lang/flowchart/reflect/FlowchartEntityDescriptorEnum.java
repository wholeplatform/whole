package org.whole.lang.flowchart.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.flowchart.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class FlowchartEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int Flowchart_ord = 0;
	public static final int Nodes_ord = 1;
	public static final int Transitions_ord = 2;
	public static final int Transition_ord = 3;
	public static final int SimpleTransition_ord = 4;
	public static final int LabeledTransition_ord = 5;
	public static final int Pixels_ord = 6;
	public static final int Text_ord = 7;
	public static final int Node_ord = 8;
	public static final int Entry_ord = 9;
	public static final int Exit_ord = 10;
	public static final int Block_ord = 11;
	public static final int Choice_ord = 12;
	public static final int Join_ord = 13;
	public static final FlowchartEntityDescriptorEnum instance = new FlowchartEntityDescriptorEnum();
	public static final EntityDescriptor<Flowchart> Flowchart = (EntityDescriptor<Flowchart>) instance
			.valueOf(Flowchart_ord);
	public static final EntityDescriptor<Nodes> Nodes = (EntityDescriptor<Nodes>) instance
			.valueOf(Nodes_ord);
	public static final EntityDescriptor<Transitions> Transitions = (EntityDescriptor<Transitions>) instance
			.valueOf(Transitions_ord);
	public static final EntityDescriptor<Transition> Transition = (EntityDescriptor<Transition>) instance
			.valueOf(Transition_ord);
	public static final EntityDescriptor<SimpleTransition> SimpleTransition = (EntityDescriptor<SimpleTransition>) instance
			.valueOf(SimpleTransition_ord);
	public static final EntityDescriptor<LabeledTransition> LabeledTransition = (EntityDescriptor<LabeledTransition>) instance
			.valueOf(LabeledTransition_ord);
	public static final EntityDescriptor<Pixels> Pixels = (EntityDescriptor<Pixels>) instance
			.valueOf(Pixels_ord);
	public static final EntityDescriptor<Text> Text = (EntityDescriptor<Text>) instance
			.valueOf(Text_ord);
	public static final EntityDescriptor<Node> Node = (EntityDescriptor<Node>) instance
			.valueOf(Node_ord);
	public static final EntityDescriptor<Entry> Entry = (EntityDescriptor<Entry>) instance
			.valueOf(Entry_ord);
	public static final EntityDescriptor<Exit> Exit = (EntityDescriptor<Exit>) instance
			.valueOf(Exit_ord);
	public static final EntityDescriptor<Block> Block = (EntityDescriptor<Block>) instance
			.valueOf(Block_ord);
	public static final EntityDescriptor<Choice> Choice = (EntityDescriptor<Choice>) instance
			.valueOf(Choice_ord);
	public static final EntityDescriptor<Join> Join = (EntityDescriptor<Join>) instance
			.valueOf(Join_ord);

	private FlowchartEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(Flowchart_ord, "Flowchart", Flowchart.class, false)
				.withFeature(FlowchartFeatureDescriptorEnum.nodes, Nodes_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.transitions,
						Transitions_ord);
		putCompositeEntity(
		Nodes_ord, "Nodes", Nodes.class, false, Node_ord, false, true);
		putCompositeEntity(
		Transitions_ord, "Transitions", Transitions.class, true, Transition_ord, false, true);
		putSimpleEntity(Transition_ord, "Transition", Transition.class, true,
				SimpleTransition_ord, LabeledTransition_ord).withFeature(
				FlowchartFeatureDescriptorEnum.source, Node_ord, false, false,
				true, false, false).withFeature(
				FlowchartFeatureDescriptorEnum.target, Node_ord, false, false,
				true, false, false);
		putSimpleEntity(SimpleTransition_ord, "SimpleTransition",
				SimpleTransition.class, false).withFeature(
				FlowchartFeatureDescriptorEnum.source, Node_ord, false, false,
				true, false, false).withFeature(
				FlowchartFeatureDescriptorEnum.target, Node_ord, false, false,
				true, false, false);
		putSimpleEntity(LabeledTransition_ord, "LabeledTransition",
				LabeledTransition.class, false)
				.withFeature(FlowchartFeatureDescriptorEnum.label, Text_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.source, Node_ord,
						false, false, true, false, false)
				.withFeature(FlowchartFeatureDescriptorEnum.target, Node_ord,
						false, false, true, false, false);
		putDataEntity(Pixels_ord, "Pixels", Pixels.class, false, int.class);
		putDataEntity(Text_ord, "Text", Text.class, false, String.class);
		putSimpleEntity(Node_ord, "Node", Node.class, true, Entry_ord,
				Exit_ord, Choice_ord, Join_ord, Block_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.x, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.y, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.width, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.height, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.description,
						Text_ord);
		putSimpleEntity(Entry_ord, "Entry", Entry.class, false)
				.withFeature(FlowchartFeatureDescriptorEnum.x, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.y, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.width, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.height, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.description,
						Text_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.sourceTransition,
						Transition_ord, false, false, true, false, false);
		putSimpleEntity(Exit_ord, "Exit", Exit.class, false)
				.withFeature(FlowchartFeatureDescriptorEnum.x, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.y, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.width, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.height, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.description,
						Text_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.targetTransition,
						Transition_ord, false, false, true, false, false);
		putSimpleEntity(Block_ord, "Block", Block.class, false)
				.withFeature(FlowchartFeatureDescriptorEnum.x, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.y, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.width, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.height, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.description,
						Text_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.targetTransition,
						Transition_ord, false, false, true, false, false)
				.withFeature(FlowchartFeatureDescriptorEnum.sourceTransition,
						Transition_ord, false, false, true, false, false);
		putSimpleEntity(Choice_ord, "Choice", Choice.class, false)
				.withFeature(FlowchartFeatureDescriptorEnum.x, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.y, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.width, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.height, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.description,
						Text_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.targetTransition,
						Transition_ord, false, false, true, false, false)
				.withFeature(
						FlowchartFeatureDescriptorEnum.trueSourceTransition,
						Transition_ord, false, false, true, false, false)
				.withFeature(
						FlowchartFeatureDescriptorEnum.falseSourceTransition,
						Transition_ord, false, false, true, false, false);
		putSimpleEntity(Join_ord, "Join", Join.class, false)
				.withFeature(FlowchartFeatureDescriptorEnum.x, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.y, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.width, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.height, Pixels_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.description,
						Text_ord)
				.withFeature(FlowchartFeatureDescriptorEnum.targetTransitions,
						Transitions_ord, false, false, true, false, false)
				.withFeature(FlowchartFeatureDescriptorEnum.sourceTransition,
						Transition_ord, false, false, true, false, false);
	}
}
