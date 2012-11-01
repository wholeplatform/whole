package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface ColumnExpression extends ISQLEntity {
	public SQLExpression getExpression();

	public void setExpression(SQLExpression expression);

	public Alias getAlias();

	public void setAlias(Alias alias);
}
