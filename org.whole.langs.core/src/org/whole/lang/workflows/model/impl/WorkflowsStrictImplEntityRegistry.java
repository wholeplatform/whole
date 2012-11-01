package org.whole.lang.workflows.model.impl;

/** 
 * @generator Whole
 */
public class WorkflowsStrictImplEntityRegistry extends
		WorkflowsImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new FaultHandlersStrictImpl());
	}
}
