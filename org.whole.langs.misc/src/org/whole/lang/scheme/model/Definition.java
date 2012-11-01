package org.whole.lang.scheme.model;

/** 
 * @generator Whole
 */
public interface Definition extends ISchemeEntity {
	public Name getName();

	public void setName(Name name);

	public SchemeExpression getExpression();

	public void setExpression(SchemeExpression expression);
}
