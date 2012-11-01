package org.whole.lang.scheme.model;

/** 
 * @generator Whole
 */
public interface Branch extends ISchemeEntity {
	public SchemeExpression getTest();

	public void setTest(SchemeExpression test);

	public SchemeExpression getBody();

	public void setBody(SchemeExpression body);
}
