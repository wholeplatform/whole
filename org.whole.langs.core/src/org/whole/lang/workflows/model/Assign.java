package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface Assign extends IWorkflowsEntity {
	public Variable getName();

	public void setName(Variable name);

	public Expression getExpression();

	public void setExpression(Expression expression);
}
