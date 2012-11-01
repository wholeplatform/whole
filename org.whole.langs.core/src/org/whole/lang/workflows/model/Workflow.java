package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface Workflow extends IWorkflowsEntity {
	public Name getName();

	public void setName(Name name);

	public Description getDescription();

	public void setDescription(Description description);

	public Declarations getDeclarations();

	public void setDeclarations(Declarations declarations);

	public StartEvent getStartEvent();

	public void setStartEvent(StartEvent startEvent);

	public FlowObject getFlowObject();

	public void setFlowObject(FlowObject flowObject);

	public FlowEvent getEndEvent();

	public void setEndEvent(FlowEvent endEvent);
}
