package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface ExpressionStatement extends IImpEntity, Statement {
	public Expression getExp();

	public void setExp(Expression exp);
}
