package org.whole.lang.flowchart.model;

/** 
 * @generator Whole
 */
public interface Block extends IFlowchartEntity, Node {
	public Transition getTargetTransition();

	public void setTargetTransition(Transition targetTransition);

	public Transition getSourceTransition();

	public void setSourceTransition(Transition sourceTransition);
}
