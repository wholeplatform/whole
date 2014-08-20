package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface JoinPointDeclaration extends IPatternsEntity, Declaration {


    public Name getName();

    public void setName(Name name);

    public Expression getExpression();

    public void setExpression(Expression expression);
}
