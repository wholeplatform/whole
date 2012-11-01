package org.whole.lang.pojo.model;

/** 
 * @generator Whole
 */
public interface PojoDeclaration extends IPojoEntity, ProductDeclaration {
	public ReferenceType getName();

	public void setName(ReferenceType name);

	public ReferenceTypes getTypes();

	public void setTypes(ReferenceTypes types);

	public Properties getProperties();

	public void setProperties(Properties properties);

	public Constructors getConstructors();

	public void setConstructors(Constructors constructors);
}
