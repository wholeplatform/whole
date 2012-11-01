package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface OnMessageEvent extends IWorkflowsEntity, StartEvent {
	public Message getMessage();

	public void setMessage(Message message);
}
