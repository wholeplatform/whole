package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface CollectByExpression extends IQueriesEntity, Expression {


    public Expressions getExpressions();

    public void setExpressions(Expressions expressions);

    public Comparator getComparator();

    public void setComparator(Comparator comparator);
}
