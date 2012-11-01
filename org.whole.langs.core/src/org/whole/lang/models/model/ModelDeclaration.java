package org.whole.lang.models.model;

/** 
 * @generator Whole
 */
public interface ModelDeclaration extends IModelsEntity {
	public EntityModifiers getModifiers();

	public void setModifiers(EntityModifiers modifiers);

	public SimpleName getName();

	public void setName(SimpleName name);

	public Types getTypes();

	public void setTypes(Types types);
}
