package org.whole.lang.flowchart.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FlowchartAdaptersEntityRegistry extends AbstractEntityRegistry {
	public FlowchartAdaptersEntityRegistry() {
		super(FlowchartEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new FlowchartAdapter());
		put(new NodesAdapter());
		put(new TransitionsAdapter());
		put(new TransitionAdapter());
		put(new SimpleTransitionAdapter());
		put(new LabeledTransitionAdapter());
		put(new PixelsAdapter());
		put(new TextAdapter());
		put(new NodeAdapter());
		put(new EntryAdapter());
		put(new ExitAdapter());
		put(new BlockAdapter());
		put(new ChoiceAdapter());
		put(new JoinAdapter());
	}
}
