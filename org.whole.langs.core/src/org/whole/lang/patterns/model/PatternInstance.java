package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface PatternInstance extends IPatternsEntity, StepExpression {


    public Name getName();

    public void setName(Name name);

    public Arguments getArguments();

    public void setArguments(Arguments arguments);
}
