package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface ConditionalExpression extends IJavaScriptEntity, Expression {
	public Expression getTest();

	public void setTest(Expression test);

	public Expression getConsequent();

	public void setConsequent(Expression consequent);

	public Expression getAlternate();

	public void setAlternate(Expression alternate);
}
