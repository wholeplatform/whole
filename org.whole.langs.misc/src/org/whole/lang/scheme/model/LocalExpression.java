package org.whole.lang.scheme.model;

/** 
 * @generator Whole
 */
public interface LocalExpression extends ISchemeEntity, SchemeExpression {
	public Definitions getDefinitions();

	public void setDefinitions(Definitions definitions);

	public SchemeExpression getBody();

	public void setBody(SchemeExpression body);
}
