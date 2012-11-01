package org.whole.lang.pojo.model;

/** 
 * @generator Whole
 */
public interface FactoryDeclaration extends IPojoEntity, Declaration {
	public ReferenceType getName();

	public void setName(ReferenceType name);

	public Name getPrefix();

	public void setPrefix(Name prefix);

	public FactoryMethods getFactoryMethods();

	public void setFactoryMethods(FactoryMethods factoryMethods);
}
