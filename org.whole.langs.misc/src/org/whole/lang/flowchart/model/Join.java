package org.whole.lang.flowchart.model;

/** 
 * @generator Whole
 */
public interface Join extends IFlowchartEntity, Node {
	public Transitions getTargetTransitions();

	public void setTargetTransitions(Transitions targetTransitions);

	public Transition getSourceTransition();

	public void setSourceTransition(Transition sourceTransition);
}
