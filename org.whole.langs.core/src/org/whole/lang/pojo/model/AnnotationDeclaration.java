package org.whole.lang.pojo.model;

/** 
 * @generator Whole
 */
public interface AnnotationDeclaration extends IPojoEntity, ProductDeclaration {
	public ReferenceType getName();

	public void setName(ReferenceType name);

	public Properties getProperties();

	public void setProperties(Properties properties);
}
