package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface DivisionStep extends IQueriesEntity, MathStep {


    public Expression getExpression();

    public void setExpression(Expression expression);
}
