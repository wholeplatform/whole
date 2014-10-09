package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface FunctionDeclaration extends IPatternsEntity, Declaration {


    public ResultTypes getApplicationTypes();

    public void setApplicationTypes(ResultTypes applicationTypes);

    public Name getName();

    public void setName(Name name);

    public PathExpression getBody();

    public void setBody(PathExpression body);
}
