package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface FunctionApplication extends ISemanticsEntity, Expression {
	public Name getName();

	public void setName(Name name);

	public Expression getArguments();

	public void setArguments(Expression arguments);

	public Environments getEnvironments();

	public void setEnvironments(Environments environments);

	public StageChange getStage();

	public void setStage(StageChange stage);
}
