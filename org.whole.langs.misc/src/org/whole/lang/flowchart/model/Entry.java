package org.whole.lang.flowchart.model;

/** 
 * @generator Whole
 */
public interface Entry extends IFlowchartEntity, Node {
	public Transition getSourceTransition();

	public void setSourceTransition(Transition sourceTransition);
}
