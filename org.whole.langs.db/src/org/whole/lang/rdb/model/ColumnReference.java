package org.whole.lang.rdb.model;

/** 
 * @generator Whole
 */
public interface ColumnReference extends IRDBEntity {
	public StringData getSource();

	public void setSource(StringData source);

	public StringData getTarget();

	public void setTarget(StringData target);
}
