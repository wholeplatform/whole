package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface CreateIndex extends ISQLEntity, SQLStatement {
	public UniqueIndex getUnique();

	public void setUnique(UniqueIndex unique);

	public IndexName getIndexName();

	public void setIndexName(IndexName indexName);

	public TableName getTableName();

	public void setTableName(TableName tableName);

	public IndexDeclarations getIndexDeclarations();

	public void setIndexDeclarations(IndexDeclarations indexDeclarations);
}
