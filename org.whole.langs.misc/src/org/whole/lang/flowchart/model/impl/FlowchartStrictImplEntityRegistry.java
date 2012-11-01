package org.whole.lang.flowchart.model.impl;

/** 
 * @generator Whole
 */
public class FlowchartStrictImplEntityRegistry extends
		FlowchartImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new NodesStrictImpl());
		put(new TransitionsStrictImpl());
	}
}
