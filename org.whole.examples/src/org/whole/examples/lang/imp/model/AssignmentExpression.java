package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface AssignmentExpression extends IImpEntity, Expression {
	public Name getName();

	public void setName(Name name);

	public Expression getExp();

	public void setExp(Expression exp);
}
