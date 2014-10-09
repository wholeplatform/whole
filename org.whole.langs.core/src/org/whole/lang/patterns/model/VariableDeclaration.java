package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface VariableDeclaration extends IPatternsEntity, Declaration {


    public Name getName();

    public void setName(Name name);

    public PathExpression getExpression();

    public void setExpression(PathExpression expression);

    public Type getResultType();

    public void setResultType(Type resultType);
}
