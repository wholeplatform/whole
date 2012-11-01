package org.whole.lang.rdb.model;

/** 
 * @generator Whole
 */
public interface ColumnIndex extends IRDBEntity {
	public StringData getName();

	public void setName(StringData name);

	public Order getOrder();

	public void setOrder(Order order);
}
