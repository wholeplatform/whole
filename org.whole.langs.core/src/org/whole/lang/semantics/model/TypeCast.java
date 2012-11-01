package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface TypeCast extends ISemanticsEntity, Expression {
	public EntityType getType();

	public void setType(EntityType type);

	public Expression getExpression();

	public void setExpression(Expression expression);
}
