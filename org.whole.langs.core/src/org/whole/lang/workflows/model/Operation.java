package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface Operation extends IWorkflowsEntity {
	public org.whole.lang.workflows.model.OperationEnum.Value getValue();

	public void setValue(
			org.whole.lang.workflows.model.OperationEnum.Value value);
}
