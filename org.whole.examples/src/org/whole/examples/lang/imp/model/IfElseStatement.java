package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface IfElseStatement extends IImpEntity, Statement {
	public Expression getCondition();

	public void setCondition(Expression condition);

	public Statement getTrueBody();

	public void setTrueBody(Statement trueBody);

	public Statement getFalseBody();

	public void setFalseBody(Statement falseBody);
}
