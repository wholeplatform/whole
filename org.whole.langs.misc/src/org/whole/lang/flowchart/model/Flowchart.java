package org.whole.lang.flowchart.model;

/** 
 * @generator Whole
 */
public interface Flowchart extends IFlowchartEntity {
	public Nodes getNodes();

	public void setNodes(Nodes nodes);

	public Transitions getTransitions();

	public void setTransitions(Transitions transitions);
}
