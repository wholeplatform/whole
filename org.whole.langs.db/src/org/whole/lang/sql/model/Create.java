package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface Create extends ISQLEntity, SQLStatement {
	public TableName getTableName();

	public void setTableName(TableName tableName);

	public DeclarationOrConstraints getDeclarationOrConstraints();

	public void setDeclarationOrConstraints(DeclarationOrConstraints declarationOrConstraints);
}
