package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface Data extends IPatternsEntity, PatternOrTypeDeclaration {


    public ResultTypes getSupertypes();

    public void setSupertypes(ResultTypes supertypes);

    public Name getName();

    public void setName(Name name);

    public DataType getDataType();

    public void setDataType(DataType dataType);
}
