package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface DerivationPoint extends IPatternsEntity, VariationPoint {


    public PathExpression getExpression();

    public void setExpression(PathExpression expression);

    public ResultType getResultType();

    public void setResultType(ResultType resultType);
}
