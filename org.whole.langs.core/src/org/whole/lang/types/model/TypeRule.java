package org.whole.lang.types.model;

/** 
 * @generator Whole
 */
public interface TypeRule extends ITypesEntity {
	public DomainType getDomain();

	public void setDomain(DomainType domain);

	public Type getType();

	public void setType(Type type);
}
