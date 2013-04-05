package org.whole.lang.patterns.model;

/** 
 * @generator Whole
 */
public interface Enumeration extends IPatternsEntity, Type {
	public Name getName();

	public void setName(Name name);

	public Type getResultType();

	public void setResultType(Type resultType);

	public EnumValues getValues();

	public void setValues(EnumValues values);
}
