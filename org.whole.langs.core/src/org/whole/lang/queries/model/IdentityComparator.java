package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface IdentityComparator extends IQueriesEntity, Comparator {


    public StepExpression getIdentity();

    public void setIdentity(StepExpression identity);
}
