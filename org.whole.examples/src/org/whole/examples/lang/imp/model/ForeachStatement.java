package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface ForeachStatement extends IImpEntity, Statement {
	public Name getName();

	public void setName(Name name);

	public Expression getArrayExp();

	public void setArrayExp(Expression arrayExp);

	public Statement getTrueBody();

	public void setTrueBody(Statement trueBody);
}
