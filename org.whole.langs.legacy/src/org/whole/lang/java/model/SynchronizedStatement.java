package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface SynchronizedStatement extends IJavaEntity, Statement {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public Block getBody();

	public void setBody(Block body);
}
