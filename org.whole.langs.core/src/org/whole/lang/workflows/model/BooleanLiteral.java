package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface BooleanLiteral extends IWorkflowsEntity, Expression {
	public boolean isValue();

	public void setValue(boolean value);
}
