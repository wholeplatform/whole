package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface NotIn extends IMathEntity, LogicExpression {
	public Expression getElement();

	public void setElement(Expression element);

	public CollectionExpression getCollection();

	public void setCollection(CollectionExpression collection);
}
