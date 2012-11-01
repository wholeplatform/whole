package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface Variable extends IWorkflowsEntity, Expression {
	public String getValue();

	public void setValue(String value);
}
