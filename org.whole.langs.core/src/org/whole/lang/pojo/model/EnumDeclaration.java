package org.whole.lang.pojo.model;

/** 
 * @generator Whole
 */
public interface EnumDeclaration extends IPojoEntity, ProductDeclaration {
	public ReferenceType getName();

	public void setName(ReferenceType name);

	public Names getValues();

	public void setValues(Names values);
}
