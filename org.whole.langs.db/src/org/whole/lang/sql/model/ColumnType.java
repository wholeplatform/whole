package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface ColumnType extends ISQLEntity {
	public Type getType();

	public void setType(Type type);

	public IntValue getSize();

	public void setSize(IntValue size);

	public IntValue getPrecision();

	public void setPrecision(IntValue precision);
}
