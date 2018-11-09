package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface BlobValue extends ISQLEntity, SQLExpression {
	public java.sql.Blob getValue();

	public void setValue(java.sql.Blob value);
}
