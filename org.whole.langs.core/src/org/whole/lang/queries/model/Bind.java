package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface Bind extends IQueriesEntity {


    public Name getName();

    public void setName(Name name);

    public PathExpressionOrPredicate getExpression();

    public void setExpression(PathExpressionOrPredicate expression);
}
