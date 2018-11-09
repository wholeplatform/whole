package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface UnionSelect extends ISQLEntity, SelectSQLStatement {
	public Select getSimpleSelect();

	public void setSimpleSelect(Select simpleSelect);

	public SelectSQLStatement getUnionSelectStatement();

	public void setUnionSelectStatement(SelectSQLStatement unionSelectStatement);
}
