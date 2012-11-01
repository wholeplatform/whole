package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface InvokeJavaInstanceMethod extends IWorkflowsEntity, Activity {
	public Variable getResult();

	public void setResult(Variable result);

	public Variable getObject();

	public void setObject(Variable object);

	public Expressions getTypeArguments();

	public void setTypeArguments(Expressions typeArguments);

	public Expression getClassName();

	public void setClassName(Expression className);

	public Expression getMethod();

	public void setMethod(Expression method);

	public Expressions getArguments();

	public void setArguments(Expressions arguments);
}
