package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface Filter extends IQueriesEntity, StepExpression {


    public StepExpression getExpression();

    public void setExpression(StepExpression expression);

    public PruneOrPredicate getPredicate();

    public void setPredicate(PruneOrPredicate predicate);
}
