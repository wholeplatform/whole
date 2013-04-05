package org.whole.lang.patterns.model;

/** 
 * @generator Whole
 */
public interface FunctionApplicationPoint extends IPatternsEntity,
		VariationPoint {
	public Name getName();

	public void setName(Name name);

	public ResultType getResultType();

	public void setResultType(ResultType resultType);
}
