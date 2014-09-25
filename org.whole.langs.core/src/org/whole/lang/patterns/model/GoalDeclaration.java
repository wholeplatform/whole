package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface GoalDeclaration extends IPatternsEntity, Declaration {


    public GoalExpression getSubgoals();

    public void setSubgoals(GoalExpression subgoals);

    public Name getName();

    public void setName(Name name);

    public Expression getBody();

    public void setBody(Expression body);
}
