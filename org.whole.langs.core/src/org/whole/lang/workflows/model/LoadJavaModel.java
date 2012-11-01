package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface LoadJavaModel extends IWorkflowsEntity, Activity {
	public Variable getModel();

	public void setModel(Variable model);

	public Expression getClassName();

	public void setClassName(Expression className);

	public ClassProvider getClassProvider();

	public void setClassProvider(ClassProvider classProvider);
}
