package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface Selector extends IMathEntity, Expression {
	public Expression getIndex();

	public void setIndex(Expression index);

	public CollectionExpression getCollection();

	public void setCollection(CollectionExpression collection);
}
