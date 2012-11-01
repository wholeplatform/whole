package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface FunctionDefinition extends IFirstOrderLogicEntity, Assertion {
	public SimpleFunction getFunction();

	public void setFunction(SimpleFunction function);

	public Parameters getParameters();

	public void setParameters(Parameters parameters);

	public Term getTerm();

	public void setTerm(Term term);
}
