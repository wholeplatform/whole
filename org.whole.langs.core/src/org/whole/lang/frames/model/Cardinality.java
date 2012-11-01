package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface Cardinality extends IFramesEntity {
	public IntValue getMin();

	public void setMin(IntValue min);

	public IntValue getMax();

	public void setMax(IntValue max);
}
