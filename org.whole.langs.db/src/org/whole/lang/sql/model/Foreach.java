package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface Foreach extends ISQLEntity, SQLStatement {
	public Name getName();

	public void setName(Name name);

	public ArrayExpr getArrayExp();

	public void setArrayExp(ArrayExpr arrayExp);

	public SQLStatement getTrueBody();

	public void setTrueBody(SQLStatement trueBody);
}
