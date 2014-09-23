package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface Call extends IQueriesEntity, StepExpression {


    public Name getName();

    public void setName(Name name);

    public Expressions getArguments();

    public void setArguments(Expressions arguments);
}
