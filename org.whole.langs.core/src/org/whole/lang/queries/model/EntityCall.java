package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface EntityCall extends IQueriesEntity, StepExpression {


    public EntityType getName();

    public void setName(EntityType name);

    public Bindings getBindings();

    public void setBindings(Bindings bindings);
}
