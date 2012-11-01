package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface CreateJavaClassInstance extends IWorkflowsEntity, Activity {
	public Variable getResult();

	public void setResult(Variable result);

	public Expressions getTypeArguments();

	public void setTypeArguments(Expressions typeArguments);

	public Expression getClassName();

	public void setClassName(Expression className);

	public Expression getConstructor();

	public void setConstructor(Expression constructor);

	public Expressions getArguments();

	public void setArguments(Expressions arguments);
}
