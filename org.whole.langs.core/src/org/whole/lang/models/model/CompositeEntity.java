package org.whole.lang.models.model;

/** 
 * @generator Whole
 */
public interface CompositeEntity extends IModelsEntity, ModelDeclaration {
	public ComponentModifiers getComponentModifiers();

	public void setComponentModifiers(ComponentModifiers componentModifiers);

	public Type getComponentType();

	public void setComponentType(Type componentType);
}
