package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface RemoveNames extends IQueriesEntity, NamesExpression {


    public NamesExpression getExpression();

    public void setExpression(NamesExpression expression);

    public Names getNames();

    public void setNames(Names names);
}
