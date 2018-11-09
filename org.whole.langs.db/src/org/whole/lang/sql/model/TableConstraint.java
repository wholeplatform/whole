package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface TableConstraint extends ISQLEntity, DeclarationOrConstraint {
	public ConstraintName getConstraintName();

	public void setConstraintName(ConstraintName constraintName);

	public ColumnNames getColumnNames();

	public void setColumnNames(ColumnNames columnNames);
}
