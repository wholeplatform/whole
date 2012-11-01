package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface ForStatement extends IImpEntity, Statement {
	public VariableDeclaration getInitializer();

	public void setInitializer(VariableDeclaration initializer);

	public Expression getCondition();

	public void setCondition(Expression condition);

	public Expression getUpdater();

	public void setUpdater(Expression updater);

	public Statement getTrueBody();

	public void setTrueBody(Statement trueBody);
}
