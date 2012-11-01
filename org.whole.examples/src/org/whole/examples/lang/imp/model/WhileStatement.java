package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface WhileStatement extends IImpEntity, Statement {
	public Expression getCondition();

	public void setCondition(Expression condition);

	public Statement getTrueBody();

	public void setTrueBody(Statement trueBody);
}
