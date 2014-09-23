package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface ParenthesizedPredicate extends IQueriesEntity, Predicate {


    public Predicate getPredicate();

    public void setPredicate(Predicate predicate);
}
