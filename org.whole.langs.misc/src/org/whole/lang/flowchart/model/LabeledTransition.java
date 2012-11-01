package org.whole.lang.flowchart.model;

/** 
 * @generator Whole
 */
public interface LabeledTransition extends IFlowchartEntity, Transition {
	public Text getLabel();

	public void setLabel(Text label);

	public Node getSource();

	public void setSource(Node source);

	public Node getTarget();

	public void setTarget(Node target);
}
