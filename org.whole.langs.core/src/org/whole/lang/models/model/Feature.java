package org.whole.lang.models.model;

/** 
 * @generator Whole
 */
public interface Feature extends IModelsEntity {
	public FeatureModifiers getModifiers();

	public void setModifiers(FeatureModifiers modifiers);

	public Type getType();

	public void setType(Type type);

	public SimpleName getName();

	public void setName(SimpleName name);

	public SimpleName getOppositeName();

	public void setOppositeName(SimpleName oppositeName);
}
