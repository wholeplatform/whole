package org.whole.lang.rdb.model;

/** 
 * @generator Whole
 */
public interface Table extends IRDBEntity {
	public StringData getName();

	public void setName(StringData name);

	public Name getEntityName();

	public void setEntityName(Name entityName);

	public Columns getColumns();

	public void setColumns(Columns columns);

	public PrimaryKey getPrimaryKey();

	public void setPrimaryKey(PrimaryKey primaryKey);

	public ForeignKeys getForeignKeys();

	public void setForeignKeys(ForeignKeys foreignKeys);

	public Indices getIndices();

	public void setIndices(Indices indices);

	public StringData getRemarks();

	public void setRemarks(StringData remarks);
}
