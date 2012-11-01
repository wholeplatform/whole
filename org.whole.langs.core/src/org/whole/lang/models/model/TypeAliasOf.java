package org.whole.lang.models.model;

/** 
 * @generator Whole
 */
public interface TypeAliasOf extends IModelsEntity, TypeRelation {
	public Type getType();

	public void setType(Type type);

	public EntityType getForeignType();

	public void setForeignType(EntityType foreignType);
}
