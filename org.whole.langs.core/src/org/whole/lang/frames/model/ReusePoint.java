package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface ReusePoint extends IFramesEntity, VariationPoint {
	public ResourceIdentifier getFrame();

	public void setFrame(ResourceIdentifier frame);

	public Features getConfiguration();

	public void setConfiguration(Features configuration);

	public Relations getRelations();

	public void setRelations(Relations relations);

	public Advices getAdvices();

	public void setAdvices(Advices advices);
}
