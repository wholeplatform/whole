package org.whole.lang.flowchart.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FlowchartEntityFactory extends GenericEntityFactory {
	public static final FlowchartEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static FlowchartEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new FlowchartEntityFactory(provider);
	}

	protected FlowchartEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Flowchart createFlowchart() {
		return create(FlowchartEntityDescriptorEnum.Flowchart);
	}

	public Flowchart createFlowchart(Nodes nodes, Transitions transitions) {
		return create(FlowchartEntityDescriptorEnum.Flowchart, nodes,
				transitions);
	}

	public IEntityBuilder<Flowchart> buildFlowchart() {
		return new EntityBuilder<Flowchart>(
				create(FlowchartEntityDescriptorEnum.Flowchart));
	}

	public Nodes createNodes() {
		return create(FlowchartEntityDescriptorEnum.Nodes);
	}

	public Nodes createNodes(Node... entities) {
		return create(FlowchartEntityDescriptorEnum.Nodes, (IEntity[]) entities);
	}

	public Nodes createNodes(int initialSize) {
		return clone(FlowchartEntityDescriptorEnum.Nodes, initialSize);
	}

	public Transitions createTransitions() {
		return create(FlowchartEntityDescriptorEnum.Transitions);
	}

	public Transitions createTransitions(Transition... entities) {
		return create(FlowchartEntityDescriptorEnum.Transitions,
				(IEntity[]) entities);
	}

	public Transitions createTransitions(int initialSize) {
		return clone(FlowchartEntityDescriptorEnum.Transitions, initialSize);
	}

	public SimpleTransition createSimpleTransition() {
		return create(FlowchartEntityDescriptorEnum.SimpleTransition);
	}

	public SimpleTransition createSimpleTransition(Node source, Node target) {
		return create(FlowchartEntityDescriptorEnum.SimpleTransition, source,
				target);
	}

	public IEntityBuilder<SimpleTransition> buildSimpleTransition() {
		return new EntityBuilder<SimpleTransition>(
				create(FlowchartEntityDescriptorEnum.SimpleTransition));
	}

	public LabeledTransition createLabeledTransition() {
		return create(FlowchartEntityDescriptorEnum.LabeledTransition);
	}

	public LabeledTransition createLabeledTransition(Text label, Node source,
			Node target) {
		return create(FlowchartEntityDescriptorEnum.LabeledTransition, label,
				source, target);
	}

	public IEntityBuilder<LabeledTransition> buildLabeledTransition() {
		return new EntityBuilder<LabeledTransition>(
				create(FlowchartEntityDescriptorEnum.LabeledTransition));
	}

	public Pixels createPixels() {
		return create(FlowchartEntityDescriptorEnum.Pixels);
	}

	public Pixels createPixels(int value) {
		return create(FlowchartEntityDescriptorEnum.Pixels, value);
	}

	public Text createText() {
		return create(FlowchartEntityDescriptorEnum.Text);
	}

	public Text createText(String value) {
		return create(FlowchartEntityDescriptorEnum.Text, value);
	}

	public Entry createEntry() {
		return create(FlowchartEntityDescriptorEnum.Entry);
	}

	public Entry createEntry(Pixels x, Pixels y, Pixels width, Pixels height,
			Text description, Transition sourceTransition) {
		return create(FlowchartEntityDescriptorEnum.Entry, x, y, width, height,
				description, sourceTransition);
	}

	public IEntityBuilder<Entry> buildEntry() {
		return new EntityBuilder<Entry>(
				create(FlowchartEntityDescriptorEnum.Entry));
	}

	public Exit createExit() {
		return create(FlowchartEntityDescriptorEnum.Exit);
	}

	public Exit createExit(Pixels x, Pixels y, Pixels width, Pixels height,
			Text description, Transition targetTransition) {
		return create(FlowchartEntityDescriptorEnum.Exit, x, y, width, height,
				description, targetTransition);
	}

	public IEntityBuilder<Exit> buildExit() {
		return new EntityBuilder<Exit>(
				create(FlowchartEntityDescriptorEnum.Exit));
	}

	public Block createBlock() {
		return create(FlowchartEntityDescriptorEnum.Block);
	}

	public Block createBlock(Pixels x, Pixels y, Pixels width, Pixels height,
			Text description, Transition targetTransition,
			Transition sourceTransition) {
		return create(FlowchartEntityDescriptorEnum.Block, x, y, width, height,
				description, targetTransition, sourceTransition);
	}

	public IEntityBuilder<Block> buildBlock() {
		return new EntityBuilder<Block>(
				create(FlowchartEntityDescriptorEnum.Block));
	}

	public Choice createChoice() {
		return create(FlowchartEntityDescriptorEnum.Choice);
	}

	public Choice createChoice(Pixels x, Pixels y, Pixels width, Pixels height,
			Text description, Transition targetTransition,
			Transition trueSourceTransition, Transition falseSourceTransition) {
		return create(FlowchartEntityDescriptorEnum.Choice, x, y, width,
				height, description, targetTransition, trueSourceTransition,
				falseSourceTransition);
	}

	public IEntityBuilder<Choice> buildChoice() {
		return new EntityBuilder<Choice>(
				create(FlowchartEntityDescriptorEnum.Choice));
	}

	public Join createJoin() {
		return create(FlowchartEntityDescriptorEnum.Join);
	}

	public Join createJoin(Pixels x, Pixels y, Pixels width, Pixels height,
			Text description, Transitions targetTransitions,
			Transition sourceTransition) {
		return create(FlowchartEntityDescriptorEnum.Join, x, y, width, height,
				description, targetTransitions, sourceTransition);
	}

	public IEntityBuilder<Join> buildJoin() {
		return new EntityBuilder<Join>(
				create(FlowchartEntityDescriptorEnum.Join));
	}
}
