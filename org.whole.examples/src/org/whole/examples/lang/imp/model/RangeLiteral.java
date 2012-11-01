package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface RangeLiteral extends IImpEntity, Literal {
	public IntLiteral getLowerBound();

	public void setLowerBound(IntLiteral lowerBound);

	public IntLiteral getUpperBound();

	public void setUpperBound(IntLiteral upperBound);
}
