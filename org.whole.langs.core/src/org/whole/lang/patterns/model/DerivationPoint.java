package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface DerivationPoint extends IPatternsEntity, VariationPoint {


    public Expression getExpression();

    public void setExpression(Expression expression);

    public ResultType getResultType();

    public void setResultType(ResultType resultType);
}
