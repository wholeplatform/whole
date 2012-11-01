package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface SwitchStatement extends IJavaEntity, Statement {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public Statements getStatements();

	public void setStatements(Statements statements);
}
