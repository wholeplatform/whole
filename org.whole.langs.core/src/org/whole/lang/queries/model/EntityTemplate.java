package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface EntityTemplate extends IQueriesEntity, StepExpression {


    public EntityType getName();

    public void setName(EntityType name);

    public Constraints getConstraints();

    public void setConstraints(Constraints constraints);
}
