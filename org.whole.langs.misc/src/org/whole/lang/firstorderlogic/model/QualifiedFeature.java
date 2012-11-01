package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface QualifiedFeature extends IFirstOrderLogicEntity, FeaturePath {
	public SimpleFeature getQualifier();

	public void setQualifier(SimpleFeature qualifier);

	public FeaturePath getFeature();

	public void setFeature(FeaturePath feature);
}
