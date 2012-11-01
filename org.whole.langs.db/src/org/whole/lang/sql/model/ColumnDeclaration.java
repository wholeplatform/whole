package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface ColumnDeclaration extends ISQLEntity, DeclarationOrConstraint {
	public ColumnName getColumnName();

	public void setColumnName(ColumnName columnName);

	public ColumnType getColumnType();

	public void setColumnType(ColumnType columnType);

	public ColumnConstraints getColumnConstraints();

	public void setColumnConstraints(ColumnConstraints columnConstraints);
}
