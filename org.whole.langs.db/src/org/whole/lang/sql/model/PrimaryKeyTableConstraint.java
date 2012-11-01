package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface PrimaryKeyTableConstraint extends ISQLEntity, TableConstraint {
	public ColumnNames getColumnNames();

	public void setColumnNames(ColumnNames columnNames);
}
