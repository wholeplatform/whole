package org.whole.lang.scheme.model;

/** 
 * @generator Whole
 */
public interface ClosureValue extends ISchemeEntity, ConstExpression {
	public Names getArgs();

	public void setArgs(Names args);

	public SchemeExpression getBody();

	public void setBody(SchemeExpression body);

	public SchemeEnvironment getEnv();

	public void setEnv(SchemeEnvironment env);
}
