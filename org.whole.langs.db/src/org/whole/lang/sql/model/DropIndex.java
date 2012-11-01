package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface DropIndex extends ISQLEntity, SQLStatement {
	public IndexName getIndexName();

	public void setIndexName(IndexName indexName);
}
