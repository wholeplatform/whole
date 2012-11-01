package org.whole.lang.flowchart.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class FlowchartImplEntityRegistry extends AbstractEntityRegistry {
	public FlowchartImplEntityRegistry() {
		super(FlowchartEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new FlowchartImpl());
		put(new NodesImpl());
		put(new TransitionsImpl());
		put(new SimpleTransitionImpl());
		put(new LabeledTransitionImpl());
		put(new PixelsImpl());
		put(new TextImpl());
		put(new EntryImpl());
		put(new ExitImpl());
		put(new BlockImpl());
		put(new ChoiceImpl());
		put(new JoinImpl());
	}
}
