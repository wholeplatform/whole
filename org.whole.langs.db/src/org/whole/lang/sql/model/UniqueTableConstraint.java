package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface UniqueTableConstraint extends ISQLEntity, TableConstraint {
	public ColumnNames getColumnNames();

	public void setColumnNames(ColumnNames columnNames);
}
