package org.whole.lang.scheme.model;

/** 
 * @generator Whole
 */
public interface LambdaExpression extends ISchemeEntity, SchemeExpression {
	public Names getArgs();

	public void setArgs(Names args);

	public SchemeExpression getBody();

	public void setBody(SchemeExpression body);
}
