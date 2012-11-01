package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface FunctionApplication extends IFirstOrderLogicEntity, Term {
	public Function getFunction();

	public void setFunction(Function function);

	public Arguments getArguments();

	public void setArguments(Arguments arguments);

	public Term getResult();

	public void setResult(Term result);
}
