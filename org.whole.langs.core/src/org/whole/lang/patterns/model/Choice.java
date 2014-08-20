package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface Choice extends IPatternsEntity, PatternOrTypeDeclaration, Type {


    public Name getName();

    public void setName(Name name);

    public Types getTypes();

    public void setTypes(Types types);

    public ResultTypes getSupertypes();

    public void setSupertypes(ResultTypes supertypes);
}
