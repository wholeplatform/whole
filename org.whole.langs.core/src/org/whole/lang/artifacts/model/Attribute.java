package org.whole.lang.artifacts.model;

/** 
 * @generator Whole
 */
public interface Attribute extends IArtifactsEntity {
	public org.whole.lang.artifacts.model.AttributeEnum.Value getValue();

	public void setValue(
			org.whole.lang.artifacts.model.AttributeEnum.Value value);
}
