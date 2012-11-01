package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface IndexDeclaration extends ISQLEntity {
	public ColumnName getColumnName();

	public void setColumnName(ColumnName columnName);

	public OrderType getOrderType();

	public void setOrderType(OrderType orderType);

	public NullOrderType getNullOrderType();

	public void setNullOrderType(NullOrderType nullOrderType);
}
