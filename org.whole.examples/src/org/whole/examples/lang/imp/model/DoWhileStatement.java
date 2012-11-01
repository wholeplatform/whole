package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface DoWhileStatement extends IImpEntity, Statement {
	public Statement getTrueBody();

	public void setTrueBody(Statement trueBody);

	public Expression getCondition();

	public void setCondition(Expression condition);
}
