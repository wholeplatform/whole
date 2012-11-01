package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface OrderByColumnExpression extends ISQLEntity {
	public SQLExpression getExpression();

	public void setExpression(SQLExpression expression);

	public OrderType getOrderType();

	public void setOrderType(OrderType orderType);
}
