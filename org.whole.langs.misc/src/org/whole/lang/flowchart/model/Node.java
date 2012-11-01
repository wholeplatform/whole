package org.whole.lang.flowchart.model;

/** 
 * @generator Whole
 */
public interface Node extends IFlowchartEntity {
	public Pixels getX();

	public void setX(Pixels x);

	public Pixels getY();

	public void setY(Pixels y);

	public Pixels getWidth();

	public void setWidth(Pixels width);

	public Pixels getHeight();

	public void setHeight(Pixels height);

	public Text getDescription();

	public void setDescription(Text description);
}
