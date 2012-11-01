package org.whole.lang.flowchart.model;

/** 
 * @generator Whole
 */
public interface Transition extends IFlowchartEntity {
	public Node getSource();

	public void setSource(Node source);

	public Node getTarget();

	public void setTarget(Node target);
}
