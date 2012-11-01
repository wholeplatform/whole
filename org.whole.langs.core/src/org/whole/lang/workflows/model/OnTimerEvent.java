package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface OnTimerEvent extends IWorkflowsEntity, StartEvent {
	public Timer getTimer();

	public void setTimer(Timer timer);
}
