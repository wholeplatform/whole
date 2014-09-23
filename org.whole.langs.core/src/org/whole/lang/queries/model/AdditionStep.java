package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface AdditionStep extends IQueriesEntity, MathStep {


    public Expression getExpression();

    public void setExpression(Expression expression);
}
