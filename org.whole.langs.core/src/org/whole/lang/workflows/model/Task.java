package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface Task extends IWorkflowsEntity, FlowObject {
	public Description getDescription();

	public void setDescription(Description description);

	public Assignments getAssignments();

	public void setAssignments(Assignments assignments);

	public Variable getFactory();

	public void setFactory(Variable factory);
}
