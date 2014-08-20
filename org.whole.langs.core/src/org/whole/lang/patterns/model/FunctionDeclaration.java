package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface FunctionDeclaration extends IPatternsEntity, Declaration {


    public ResultTypes getApplicationTypes();

    public void setApplicationTypes(ResultTypes applicationTypes);

    public Name getName();

    public void setName(Name name);

    public Expression getBody();

    public void setBody(Expression body);
}
