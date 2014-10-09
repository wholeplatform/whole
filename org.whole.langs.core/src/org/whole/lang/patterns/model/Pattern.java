package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface Pattern extends IPatternsEntity, PatternOrTypeDeclaration {


    public ResultTypes getResultTypes();

    public void setResultTypes(ResultTypes resultTypes);

    public Name getName();

    public void setName(Name name);

    public Template getTemplate();

    public void setTemplate(Template template);
}
