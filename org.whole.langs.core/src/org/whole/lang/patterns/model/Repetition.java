package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface Repetition extends IPatternsEntity, PatternOrTypeDeclaration, Type {


    public Name getName();

    public void setName(Name name);

    public Type getType();

    public void setType(Type type);

    public ResultTypes getSupertypes();

    public void setSupertypes(ResultTypes supertypes);
}
