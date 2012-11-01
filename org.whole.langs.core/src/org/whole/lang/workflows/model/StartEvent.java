package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface StartEvent extends IWorkflowsEntity, Event {
	public Name getName();

	public void setName(Name name);

	public Label getLabel();

	public void setLabel(Label label);
}
