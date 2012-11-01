package org.whole.lang.actions.model;

/** 
 * @generator Whole
 */
public interface SimpleAction extends IActionsEntity, Action {
	public Label getName();

	public void setName(Label name);

	public Transformation getTransformation();

	public void setTransformation(Transformation transformation);
}
