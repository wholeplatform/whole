package org.whole.lang.models.model;

/** 
 * @generator Whole
 */
public interface SupertypesOf extends IModelsEntity, TypeRelation {
	public Types getTypes();

	public void setTypes(Types types);

	public ForeignType getForeignType();

	public void setForeignType(ForeignType foreignType);
}
