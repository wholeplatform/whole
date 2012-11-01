package org.whole.lang.rdb.model;

/** 
 * @generator Whole
 */
public interface PrimaryKey extends IRDBEntity {
	public StringData getName();

	public void setName(StringData name);

	public IdMethod getIdMethod();

	public void setIdMethod(IdMethod idMethod);

	public ColumnNames getColumnNames();

	public void setColumnNames(ColumnNames columnNames);
}
