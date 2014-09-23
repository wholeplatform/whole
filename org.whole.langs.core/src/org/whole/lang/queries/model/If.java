package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface If extends IQueriesEntity, PathExpression {


    public Predicate getPredicate();

    public void setPredicate(Predicate predicate);

    public PathExpression getExpression();

    public void setExpression(PathExpression expression);
}
