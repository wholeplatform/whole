package org.whole.lang.flowchart.model;

/** 
 * @generator Whole
 */
public interface Choice extends IFlowchartEntity, Node {
	public Transition getTargetTransition();

	public void setTargetTransition(Transition targetTransition);

	public Transition getTrueSourceTransition();

	public void setTrueSourceTransition(Transition trueSourceTransition);

	public Transition getFalseSourceTransition();

	public void setFalseSourceTransition(Transition falseSourceTransition);
}
