package org.whole.lang.rdb.model;

/** 
 * @generator Whole
 */
public interface Schema extends IRDBEntity {
	public StringData getName();

	public void setName(StringData name);

	public StringData getModelName();

	public void setModelName(StringData modelName);

	public Tables getTables();

	public void setTables(Tables tables);
}
