package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface SetClause extends ISQLEntity {
	public ColumnName getColumnName();

	public void setColumnName(ColumnName columnName);

	public SQLExpression getExpression();

	public void setExpression(SQLExpression expression);
}
