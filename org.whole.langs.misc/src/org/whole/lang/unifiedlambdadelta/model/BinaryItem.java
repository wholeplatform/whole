package org.whole.lang.unifiedlambdadelta.model;

/** 
 * @generator Whole
 */
public interface BinaryItem extends IUnifiedLambdaDeltaEntity {
	public Polarity getPolarity();

	public void setPolarity(Polarity polarity);

	public Term getFront();

	public void setFront(Term front);
}
