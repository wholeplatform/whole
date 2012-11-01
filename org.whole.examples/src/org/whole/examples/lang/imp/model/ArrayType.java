package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface ArrayType extends IImpEntity, Type {
	public Type getContentType();

	public void setContentType(Type contentType);

	public PrimitiveType getIndexType();

	public void setIndexType(PrimitiveType indexType);
}
