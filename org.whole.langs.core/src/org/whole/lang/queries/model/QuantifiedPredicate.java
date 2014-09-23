package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface QuantifiedPredicate extends IQueriesEntity, Predicate {


    public PathExpression getFromClause();

    public void setFromClause(PathExpression fromClause);

    public Predicate getWhereClause();

    public void setWhereClause(Predicate whereClause);
}
