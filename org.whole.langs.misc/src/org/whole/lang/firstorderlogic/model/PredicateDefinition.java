package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface PredicateDefinition extends IFirstOrderLogicEntity, Assertion {
	public SimplePredicate getPredicate();

	public void setPredicate(SimplePredicate predicate);

	public Parameters getParameters();

	public void setParameters(Parameters parameters);

	public Formula getStatement();

	public void setStatement(Formula statement);
}
