package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface NameDeclaration extends IFirstOrderLogicEntity, Declaration {
	public Name getName();

	public void setName(Name name);

	public Type getType();

	public void setType(Type type);

	public Path getModelBinding();

	public void setModelBinding(Path modelBinding);
}
