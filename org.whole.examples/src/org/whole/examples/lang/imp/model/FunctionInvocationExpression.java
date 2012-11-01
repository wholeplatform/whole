package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface FunctionInvocationExpression extends IImpEntity, Expression {
	public NameExpression getName();

	public void setName(NameExpression name);

	public Arguments getArguments();

	public void setArguments(Arguments arguments);
}
