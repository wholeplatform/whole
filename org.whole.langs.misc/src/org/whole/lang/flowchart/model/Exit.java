package org.whole.lang.flowchart.model;

/** 
 * @generator Whole
 */
public interface Exit extends IFlowchartEntity, Node {
	public Transition getTargetTransition();

	public void setTargetTransition(Transition targetTransition);
}
