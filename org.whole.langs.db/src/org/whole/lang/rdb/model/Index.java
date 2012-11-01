package org.whole.lang.rdb.model;

/** 
 * @generator Whole
 */
public interface Index extends IRDBEntity {
	public StringData getName();

	public void setName(StringData name);

	public StringData getQualifier();

	public void setQualifier(StringData qualifier);

	public BooleanData getUnique();

	public void setUnique(BooleanData unique);

	public IndexType getType();

	public void setType(IndexType type);

	public ColumnIndices getColumnIndices();

	public void setColumnIndices(ColumnIndices columnIndices);
}
